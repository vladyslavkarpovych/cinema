package com.gmail.karpovych.springdemoboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user", schema = "kino_cms")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String firstName;

    @Column(name = "user_surname")
    private String lastName;

    @Column(name = "user_alias")
    private String userAlias;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_card_number")
    private BigInteger userCardNumber;

    @Column(name = "user_language")
    private String userLanguage;

    @Column(name = "user_sex")
    private String userSex;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    @Column(name = "user_city")
    private String userCity;

    @Column(name = "user_birthday")
    private Date userBirthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}