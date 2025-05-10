# # -*- coding: utf-8 -*-

# 数据爬取文件

import scrapy
import pymysql
import pymssql
from ..items import ShoujiItem
import time
from datetime import datetime,timedelta
import re
import random
import platform
import json
import os
import urllib
from urllib.parse import urlparse
import requests
import emoji
from selenium.webdriver import ChromeOptions, ActionChains
from scrapy.http import TextResponse
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
# 手机
class ShoujiSpider(scrapy.Spider):
    name = 'shoujiSpider'
    spiderUrl = 'https://s.taobao.com/search?q=手机'
    start_urls = spiderUrl.split(";")
    protocol = ''
    hostname = ''
    realtime = False


    def __init__(self,realtime=False,*args, **kwargs):
        super().__init__(*args, **kwargs)
        self.realtime = realtime=='true'

    def start_requests(self):

        plat = platform.system().lower()
        if not self.realtime and (plat == 'linux' or plat == 'windows'):
            connect = self.db_connect()
            cursor = connect.cursor()
            if self.table_exists(cursor, '89b6350z_shouji') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return

        pageNum = 1 + 1
        for url in self.start_urls:
            if '{}' in url:
                for page in range(1, pageNum):
                    next_link = url.format(page)
                    yield scrapy.Request(
                        url=next_link,
                        callback=self.parse
                    )
            else:
                yield scrapy.Request(
                    url=url,
                    callback=self.parse
                )

    # 列表解析
    def parse(self, response):

        _url = urlparse(self.spiderUrl)
        self.protocol = _url.scheme
        self.hostname = _url.netloc
        plat = platform.system().lower()
        if not self.realtime and (plat == 'linux' or plat == 'windows'):
            connect = self.db_connect()
            cursor = connect.cursor()
            if self.table_exists(cursor, '89b6350z_shouji') == 1:
                cursor.close()
                connect.close()
                self.temp_data()
                return

        list = response.css('a.Card--doubleCardWrapper--L2XFE73')
        
        for item in list:

            fields = ShoujiItem()



            try:
                fields["title"] = item.xpath("//div[@class='Title--title--jCOPvpf']/span//text()").extract()[0].strip()
            except:
                pass
            if '(.*?)' in '''div.Title--title--jCOPvpf img::attr(src)''':
                try:
                    fields["picture"] = re.findall(r'''div.Title--title--jCOPvpf img::attr(src)''', item.extract(), re.DOTALL)[0].strip()
                except:
                    pass
            else:
                fields["picture"] = self.remove_html(item.css('div.Title--title--jCOPvpf img::attr(src)').extract_first())
            if '(.*?)' in '''div.Price--priceWrapper--Q0Dn7pN span.Price--priceInt--ZlsSi_M::text''':
                try:
                    fields["price"] = re.findall(r'''div.Price--priceWrapper--Q0Dn7pN span.Price--priceInt--ZlsSi_M::text''', item.extract(), re.DOTALL)[0].strip()
                except:
                    pass
            else:
                fields["price"] = self.remove_html(item.css('div.Price--priceWrapper--Q0Dn7pN span.Price--priceInt--ZlsSi_M::text').extract_first())
            if '(.*?)' in '''div.Price--priceWrapper--Q0Dn7pN span.Price--realSales--FhTZc7U::text''':
                try:
                    fields["realsales"] = re.findall(r'''div.Price--priceWrapper--Q0Dn7pN span.Price--realSales--FhTZc7U::text''', item.extract(), re.DOTALL)[0].strip()
                except:
                    pass
            else:
                fields["realsales"] = self.remove_html(item.css('div.Price--priceWrapper--Q0Dn7pN span.Price--realSales--FhTZc7U::text').extract_first())
            if '(.*?)' in '''div.ShopInfo--TextAndPic--yH0AZfx a::text''':
                try:
                    fields["shopname"] = re.findall(r'''div.ShopInfo--TextAndPic--yH0AZfx a::text''', item.extract(), re.DOTALL)[0].strip()
                except:
                    pass
            else:
                fields["shopname"] = self.remove_html(item.css('div.ShopInfo--TextAndPic--yH0AZfx a::text').extract_first())
            if '(.*?)' in '''a.Card--doubleCardWrapper--L2XFE73::attr(href)''':
                try:
                    fields["laiyuan"] = re.findall(r'''a.Card--doubleCardWrapper--L2XFE73::attr(href)''', item.extract(), re.DOTALL)[0].strip()
                except:
                    pass
            else:
                fields["laiyuan"] = self.remove_html(item.css('a.Card--doubleCardWrapper--L2XFE73::attr(href)').extract_first())

            detailUrlRule = item.css('a.Card--doubleCardWrapper--L2XFE73::attr(href)').extract_first()
            if self.protocol in detailUrlRule:
                pass
            elif detailUrlRule.startswith('//'):
                detailUrlRule = self.protocol + ':' + detailUrlRule
            elif detailUrlRule.startswith('/'):
                detailUrlRule = self.protocol + '://' + self.hostname + detailUrlRule
                # fields["laiyuan"] = detailUrlRule
            else:
                detailUrlRule = self.protocol + '://' + self.hostname + '/' + detailUrlRule

            yield scrapy.Request(url=detailUrlRule, meta={'fields': fields},  callback=self.detail_parse, dont_filter=True)


    # 详情解析
    def detail_parse(self, response):
        fields = response.meta['fields']

        try:
            fields["jcolor"] = response.xpath('''//ul[@data-property='机身颜色']/li/a//text()''').extract()[0].strip()
        except:
            pass

        try:
            fields["ccsize"] = response.xpath('''//ul[@data-property='存储容量']/li/a//text()''').extract()[0].strip()
        except:
            pass

        try:
            fields["pinpai"] = response.xpath('''//p[contains(text(), "品牌:")]/text()''').extract()[0].strip()
        except:
            pass

        try:
            fields["xinghao"] = response.xpath('''//p[contains(text(), "型号:")]/text()''').extract()[0].strip()
        except:
            pass

        try:
            fields["fenbianlv"] = response.xpath('''//p[contains(text(), "分辨率:")]/text()''').extract()[0].strip()
        except:
            pass

        try:
            fields["bianhao"] = response.xpath('''//p[contains(text(), "3C证书编号:")]/a/text()''').extract()[0].strip()
        except:
            pass


        return fields

    # 去除多余html标签
    def remove_html(self, html):
        if html == None:
            return ''
        pattern = re.compile(r'<[^>]+>', re.S)
        return pattern.sub('', html).strip()

    # 数据库连接
    def db_connect(self):
        type = self.settings.get('TYPE', 'mysql')
        host = self.settings.get('HOST', 'localhost')
        port = int(self.settings.get('PORT', 3306))
        user = self.settings.get('USER', 'root')
        password = self.settings.get('PASSWORD', '123456')

        try:
            database = self.databaseName
        except:
            database = self.settings.get('DATABASE', '')

        if type == 'mysql':
            connect = pymysql.connect(host=host, port=port, db=database, user=user, passwd=password, charset='utf8')
        else:
            connect = pymssql.connect(host=host, user=user, password=password, database=database)

        return connect

    # 断表是否存在
    def table_exists(self, cursor, table_name):
        cursor.execute("show tables;")
        tables = [cursor.fetchall()]
        table_list = re.findall('(\'.*?\')',str(tables))
        table_list = [re.sub("'",'',each) for each in table_list]

        if table_name in table_list:
            return 1
        else:
            return 0

    # 数据缓存源
    def temp_data(self):

        connect = self.db_connect()
        cursor = connect.cursor()
        sql = '''
            insert into `shouji`(
                id
                ,title
                ,picture
                ,price
                ,realsales
                ,shopname
                ,jcolor
                ,ccsize
                ,pinpai
                ,xinghao
                ,fenbianlv
                ,bianhao
                ,laiyuan
            )
            select
                id
                ,title
                ,picture
                ,price
                ,realsales
                ,shopname
                ,jcolor
                ,ccsize
                ,pinpai
                ,xinghao
                ,fenbianlv
                ,bianhao
                ,laiyuan
            from `89b6350z_shouji`
            where(not exists (select
                id
                ,title
                ,picture
                ,price
                ,realsales
                ,shopname
                ,jcolor
                ,ccsize
                ,pinpai
                ,xinghao
                ,fenbianlv
                ,bianhao
                ,laiyuan
            from `shouji` where
                `shouji`.id=`89b6350z_shouji`.id
            ))
        '''

        cursor.execute(sql)
        connect.commit()

        connect.close()
