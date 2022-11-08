package com.mustache.bbs.domain.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Entity선언
@Entity //JPA에서 객체로 다루겠다는 선언
@Table(name="article2")
@Getter
@NoArgsConstructor
public class Article {

    @Id //엔터티가 붙어있다면 꼭! 붙어 있어야 한다. id(PK)를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Article(String title) {
        this.title = title;
    }
}
