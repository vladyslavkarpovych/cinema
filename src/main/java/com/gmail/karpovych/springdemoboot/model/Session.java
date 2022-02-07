package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "session", schema = "kino_cms")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "film_id")
    private Integer filmId;
    @Column(name = "cinema_id")
    private Integer cinemaId;
    @Column(name = "hall_id")
    private Integer hallId;
    @Column(name = "hall_free_places")
    private Integer hallFreePlaces;
    @Column(name = "session_begins")
    private Timestamp sessionBegins;
    @Column(name = "session_ends")
    private Timestamp sessionEnds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Session session = (Session) o;
        return sessionId != null && Objects.equals(sessionId, session.sessionId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
