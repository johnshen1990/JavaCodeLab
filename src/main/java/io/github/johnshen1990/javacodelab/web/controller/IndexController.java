package io.github.johnshen1990.javacodelab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: zhun.shen
 * Date: 2016-04-08 15:08
 * Description:
 */
@Controller
public class IndexController {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        System.out.println("index called");
        return "static/index.html";
    }
}
