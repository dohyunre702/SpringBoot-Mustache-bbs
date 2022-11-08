package com.mustache.bbs.domain.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// Entity선언
@Entity //JPA에서 객체로 다루겠다는 선언
@Table(name="article2")
@Getter
@NoArgsConstructor
public class Article {

    @Id //엔터티가 붙어있다면 꼭! 붙어 있어야 한다. id(PK)를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 id생성 맡김
    private Long id;
    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
