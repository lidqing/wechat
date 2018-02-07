package com.nationsky.base.controller;

import com.nationsky.base.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LDQ
 * @Date Created in 19:36 2018/2/7
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ApplicationConfig applicationConfig;

    @RequestMapping("/staticvar")
    public @ResponseBody
    String loadStaticVar(){
        System.out.println("ApplicationConfig.DOMAIN:"+this.applicationConfig.getDomain());
        return  "var domain = '"+this.applicationConfig.getDomain() +"';";
    }
}
