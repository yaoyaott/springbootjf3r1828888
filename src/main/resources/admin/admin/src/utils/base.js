const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootjf3r1828/",
            name: "springbootjf3r1828",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootjf3r1828/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Spark的电商用户行为分析系统"
        } 
    }
}
export default base
