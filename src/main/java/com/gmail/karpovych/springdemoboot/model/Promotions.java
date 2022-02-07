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
@Table(name = "promotions", schema = "kino_cms")
public class Promotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionsId;
    @Column(name = "cinema_id")
    private Integer cinemaId;
    @Column(name = "promotions_name")
    private String promotionsName;
    @Column(name = "promotions_description")
    private String promotionsDescription;
    @Column(name = "promotions_date")
    private Date promotionsDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Promotions that = (Promotions) o;
        return promotionsId != null && Objects.equals(promotionsId, that.promotionsId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
