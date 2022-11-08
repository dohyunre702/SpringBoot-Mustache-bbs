package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entitiy.Article;
import org.springframework.data.jpa.repository.JpaRepository;

//리포지토리 사용
public interface ArticleRepository  extends JpaRepository<Article,Long> {
}
