package com.x.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "tid_Sequence")
    @SequenceGenerator(name = "tid_Sequence", sequenceName = "TID_SEQ")
    private Long id;
    private String token;
    @OneToOne(fetch = LAZY)
    private Userr userr;
    private Instant expiryDate;
}