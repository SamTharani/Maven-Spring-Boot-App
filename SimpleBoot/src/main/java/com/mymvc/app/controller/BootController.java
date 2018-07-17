package com.mymvc.app.controller;

import com.mymvc.app.model.BootUser;
import com.mymvc.app.repository.BootRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BootController {

    @Autowired
    BootRepo bootRepo;

    String userName;

    @RequestMapping("/")
    public String bootIndex(){
        BootUser user = new BootUser();
        user.setUserName("BootMan");
        user.setPassword("test123@");
        bootRepo.save(user);
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam String userName, @RequestParam String password){

        BootUser user = new BootUser();
        this.userName = userName;
        user.setUserName(userName);
        user.setPassword(password);
        bootRepo.save(user);
        return userName;
    }

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView model){
        model.addObject("userName",userName);
        model.setViewName("home");
        return model;
    }

}
