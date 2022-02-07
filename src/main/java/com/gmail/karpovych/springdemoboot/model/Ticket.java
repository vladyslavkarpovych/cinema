package com.gmail.karpovych.springdemoboot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ticket", schema = "kino_cms")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    @Column(name = "user_id")
    private BigInteger userId;
    @Column(name = "ticket_session")
    private Integer ticketSession;
    @Column(name = "ticket_row_number")
    private Integer ticketRowNumber;
    @Column(name = "ticket_place_number")
    private Integer ticketPlaceNumber;
    @Column(name = "ticket_payment_status")
    private String ticketPaymentStatus;
    @Column(name = "price")
    private Float ticketPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket ticket = (Ticket) o;
        return ticketId != null && Objects.equals(ticketId, ticket.ticketId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
