package com.mustache.bbs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    @GetMapping(value="/new")
    public String newArticleForm() {///articles/new url로 들어오면 artices/new.mustache를 출력
        return "articles/new";
    }
}
