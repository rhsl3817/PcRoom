package com.example.pcroom.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "member_id",nullable = false,foreignKey = @ForeignKey(name ="FK_MEMBER_TB_RESERVATION"))
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "computer_id",nullable = false,foreignKey = @ForeignKey(name ="FK_COMPUTER_TB_RESERVATION"))
    private Computer computer;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endtDate;

    @Column(nullable = false)
    private int totalPrice;
}