package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entitiy.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//리포지토리 사용
@Repository
public interface ArticleRepository  extends JpaRepository<Article,Long> {
}
