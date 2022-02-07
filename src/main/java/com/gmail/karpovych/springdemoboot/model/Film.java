package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "film", schema = "kino_cms")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "film_genre_id")
    private String filmGenreId;
    @Column(name = "film_duration")
    private Time filmDuration;
    @Column(name = "film_production")
    private String filmProductionBy;
    @Column(name = "film_production_country")
    private String filmProductionCountryBy;
    @Column(name = "film_rental_begins")
    private Date filmRentalBegins;
    @Column(name = "film_age_restrictions")
    private String filmAgeRestrictions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Film film = (Film) o;
        return filmId != null && Objects.equals(filmId, film.filmId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
