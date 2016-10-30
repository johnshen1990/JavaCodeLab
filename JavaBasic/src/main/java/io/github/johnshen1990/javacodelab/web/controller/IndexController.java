package io.github.johnshen1990.javacodelab.web.controller;

import io.github.johnshen1990.javacodelab.javabasic.encode.Person;
import org.apache.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
        return "index";
    }

    @RequestMapping(value = "redirectTest")
    public void redirectTest(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader(HttpHeaders.LOCATION, "http://localhost:8080/freemarkerTest");
    }

    @RequestMapping(value = "freemarkerTest")
    public ModelAndView freemarkerTest(){
        ModelAndView mv = new ModelAndView("index");
        String nullValue = null;
        String emptyStringValue = "";
        String blankStringValue = " ";
        mv.addObject("nullValue", nullValue);
        mv.addObject("emptyStringValue", emptyStringValue);
        mv.addObject("blankStringValue", blankStringValue);
        mv.addObject("startDate", null);
        return mv;
    }

    @RequestMapping(value = "postEncodingTest", method = RequestMethod.POST)
    @ResponseBody
    public Person postEncodingTest(@RequestBody Person person){
        return person;
    }

    @RequestMapping(value = "getEncodingTest", method = RequestMethod.GET)
    @ResponseBody
    public Person getEncodingTest(@RequestParam String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

}
