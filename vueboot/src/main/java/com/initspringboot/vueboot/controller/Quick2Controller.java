package com.initspringboot.vueboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "person")  ///*自动从配置文件中查找数据*/
public class Quick2Controller {

    /*@Value("${name}")
    private  String name;*/

    private  String name;
    private  String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @RequestMapping("/quick2")
    @ResponseBody
    public String quick2(){
        //获得配置文件

        return "name:"+name+","+"addr:"+addr;
    }


}
