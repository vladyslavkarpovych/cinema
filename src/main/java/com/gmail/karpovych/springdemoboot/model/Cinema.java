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
@Table(name = "cinema", schema = "kino_cms")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;
    @Column(name = "cinema_name")
    private String cinemaName;
    @Column(name = "cinema_address")
    private String cinemaAddress;
    @Column(name = "cinema_phone_number")
    private String cinemaPhoneNumber;
    @Column(name = "cinema_description")
    private String cinemaDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cinema cinema = (Cinema) o;
        return cinemaId != null && Objects.equals(cinemaId, cinema.cinemaId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
