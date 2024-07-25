const base = {
    get() {
        return {
            url : "http://localhost:8080/yiyuanyaopinguanli/",
            name: "yiyuanyaopinguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiyuanyaopinguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "医院药品管理系统"
        } 
    }
}
export default base
