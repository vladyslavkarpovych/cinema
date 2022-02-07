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
@Table(name = "genre", schema = "kino_cms")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;
    @Column(name = "genre_name")
    private String genreName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genre genre = (Genre) o;
        return genreId != null && Objects.equals(genreId, genre.genreId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
