package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entitiy.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    //Spring이 ArticleRepository 구현체를 DI(인터페이스 아님)
    private final ArticleRepository articleRepository;

    //autowired보다 생성자로 주입하는 형식을 더 많이 씀
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // /list일 때
    @GetMapping("/list")
    public String list(Model model) { //파라미터로 모델 연결. list에 값 넘겨주기
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }

    // /일 때
    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    @GetMapping(value="/new")
    public String newArticleForm() {///articles/new url로 들어오면 artices/new.mustache를 출력
        return "articles/new";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        //잘 들어갔을 때 show로 가도록 라우팅
        if(!optArticle.isEmpty()) {
            //Optional.get() --> Article
            model.addAttribute("article", optArticle.get());
            return "show";
        } else {
            return "error";
        }
    }

    @PostMapping(value="") //articles
    public String createArticle(ArticleDto form) {
        //로그 : 서버에서 일어나는 일 기록 (not println)
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return "";
    }

    @PostMapping("") //다른 페이지로 이동처리
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());

        return String.format("redirect:/articles/%d", savedArticle.getId());
    }
}