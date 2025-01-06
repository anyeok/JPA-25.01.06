package com.ll.sb_25_01.domain.article.service;

import com.ll.sb_25_01.domain.article.entity.Article;
import com.ll.sb_25_01.domain.article.repository.ArticleRepository;
import com.ll.sb_25_01.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .authorId(authorId)
                .title(title)
                .body(body)
                .build();
        articleRepository.save(article);

        return RsData.of("200", "%d번 게시물이 작성되었습니다.".formatted(article.getId()), article);
    }
}
