package io.github.johnshen1990.javawebapp.controller;

import io.github.johnshen1990.javawebapp.properties.ConfigBean;
import io.github.johnshen1990.javawebapp.properties.MyPropBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private MyPropBean myPropBean;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        System.out.println(configBean.getNickName());
        System.out.println(configBean.getGender());
        System.out.println(myPropBean.getNickName());
        System.out.println(myPropBean.getGender());
        return mv;
    }
}
