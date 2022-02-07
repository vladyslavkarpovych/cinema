package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "news", schema = "kino_cms")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsId;
    @Column(name = "cinema_id")
    private Integer cinemaId;
    @Column(name = "news_description")
    private String newsDescription;
    @Column(name = "news_date")
    private Date newsDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        News news = (News) o;
        return newsId != null && Objects.equals(newsId, news.newsId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
