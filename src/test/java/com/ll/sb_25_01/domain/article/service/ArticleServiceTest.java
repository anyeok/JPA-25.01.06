package com.ll.sb_25_01.domain.article.service;

import com.ll.sb_25_01.domain.article.entity.Article;
import com.ll.sb_25_01.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Rollback(false)
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @DisplayName("글 쓰기")
    @Test
    void t1() {
        RsData<Article> joinRs = articleService.write("제목", "내용");
        Article article = joinRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }
}