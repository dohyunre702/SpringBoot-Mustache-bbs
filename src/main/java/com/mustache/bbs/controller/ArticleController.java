package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entitiy.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    //autowired보다 생성자로 주입하는 형식을 더 많이 씀
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value="/new")
    public String newArticleForm() {///articles/new url로 들어오면 artices/new.mustache를 출력
        return "articles/new";
    }

    @PostMapping(value="/new") //articles
    public String createArticle(ArticleDto form) {
        //로그 : 서버에서 일어나는 일 기록 (not println)
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return "";
    }

}