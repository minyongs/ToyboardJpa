package org.example.jpaboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/")
    public String list(){
        return "/list";
    }

    @GetMapping("/write")
    public String write(){
        return "/write";
    }

    @GetMapping("/update")
    public String update(){
        return "/update";

    }

}
