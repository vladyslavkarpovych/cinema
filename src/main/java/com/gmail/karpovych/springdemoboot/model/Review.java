package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "review", schema = "kino_cms")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @Column(name = "film_id")
    private Integer filmId;
    @Column(name = "review_rate")
    private String reviewRate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Review review = (Review) o;
        return reviewId != null && Objects.equals(reviewId, review.reviewId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
