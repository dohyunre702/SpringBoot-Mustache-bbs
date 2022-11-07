package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    @GetMapping(value="/new")
    public String newArticleForm() {///articles/new url로 들어오면 artices/new.mustache를 출력
        return "articles/new";
    }

    @PostMapping(value="/posts")
    public String createArticle(ArticleDto form) {
        //로그 : 서버에서 일어나는 일 기록 (not println)
        log.info(form.toString());
        return "";
    }
}