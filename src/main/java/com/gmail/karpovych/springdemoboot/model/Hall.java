package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "hall", schema = "kino_cms")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hallId;
    @Column(name = "hall_name")
    private String hallName;
    @Column(name = "hall_works")
    private Boolean hallWorks;
    @Column(name = "number_of_places")
    private Integer numberOfPlaces;
    @Column(name = "number_of_rows")
    private Integer numberOfRows;
    @Column(name = "hall_capacity")
    private Integer hallCapacity;
    @Column(name = "belonging_to_cinema")
    private Integer belongingToCinema;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hall hall = (Hall) o;
        return hallId != null && Objects.equals(hallId, hall.hallId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
