package org.example.jpaboard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/main")
    public String main(){
        return "main/main";
    }

    @GetMapping("/list")
    public String list(){
        return "list.html";
    }

}



