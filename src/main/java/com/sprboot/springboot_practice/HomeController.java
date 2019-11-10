package com.sprboot.springboot_practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("home")
    public ModelAndView home(@RequestParam("name") String myName) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", myName);

        return mv;
    }
}
