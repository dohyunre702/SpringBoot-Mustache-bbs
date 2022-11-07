package com.mustache.bbs.domain.entitiy;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
public class Article {

    @Id
    private Long id;

}
