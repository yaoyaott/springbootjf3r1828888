# 数据容器文件

import scrapy

class SpiderItem(scrapy.Item):
    pass

class ShoujiItem(scrapy.Item):
    # 标题
    title = scrapy.Field()
    # 图片
    picture = scrapy.Field()
    # 价格
    price = scrapy.Field()
    # 付款人数
    realsales = scrapy.Field()
    # 商家
    shopname = scrapy.Field()
    # 机身颜色
    jcolor = scrapy.Field()
    # 存储容量
    ccsize = scrapy.Field()
    # 品牌
    pinpai = scrapy.Field()
    # 型号
    xinghao = scrapy.Field()
    # 分辨率
    fenbianlv = scrapy.Field()
    # 3C证书编号
    bianhao = scrapy.Field()
    # 来源
    laiyuan = scrapy.Field()

