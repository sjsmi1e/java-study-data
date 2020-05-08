package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-14 下午9:02
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
public class ViewController {


    @RequestMapping("/index")
    public String index(){
        System.out.println("进入 index");
        return "index";
    }
}
