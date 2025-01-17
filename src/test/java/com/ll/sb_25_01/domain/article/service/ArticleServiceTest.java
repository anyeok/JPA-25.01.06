package com.ll.sb_25_01.domain.article.service;

import com.ll.sb_25_01.domain.article.entity.Article;
import com.ll.sb_25_01.domain.member.entity.Member;
import com.ll.sb_25_01.domain.member.service.MemberService;
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
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MemberService memberService;

    @DisplayName("글 쓰기")
    @Test
    @Rollback(false)
    void t1() {
        RsData<Article> joinRs = articleService.write(1, "제목", "내용");
        Article article = joinRs.getData();

        assertThat(article.getId()).isGreaterThan(0L);
    }

    @DisplayName("1번 글의 작성자는 user1")
    @Test
    void t2() {
        Article article = articleService.findById(1L).get();

        Member author = article.getAuthor();

        assertThat(author.getUsername()).isEqualTo("user1");
    }

    @DisplayName("1번 글 작성자는 user1")
    @Test
    void t3() {
        Article article = articleService.findById(1L).get();

        Member author = article.getAuthor();

        assertThat(author.getUsername()).isEqualTo("user1");
    }

    @DisplayName("1번 글 제목 수정")
    @Test
    @Rollback(false)
    void t4() {
        Article article = articleService.findById(1L).get();

        articleService.modify(article, "수정된 제목", "수정된 내용");

        Article _article = articleService.findById(1L).get();
        assertThat(_article.getTitle()).isEqualTo("수정된 제목");
    }
}