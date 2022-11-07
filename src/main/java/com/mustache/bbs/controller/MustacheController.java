package com.mustache.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller //컨트롤러 선언
public class MustacheController {

    @GetMapping(value="/hi") //endpoint 매핑
    public String mustacheCon(Model model) { //Model model 파라미터
        model.addAttribute("username", "rok"); //view에 값을 넘기겠다.
        return "greetings"; //view를 리턴
    }
}
