package com.polytech.mentoring.domain;

import com.polytech.mentoring.domain.enums.DealStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deal")
public class Deal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(targetEntity = Tutor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne(targetEntity = Guarantee.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "guarantee_id")
    private Guarantee guarantee;

    @Column(name = "coast", nullable = false)
    private int cost;

    // дата заключения договора
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "conditional", nullable = false)
    private String conditional;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DealStatus status;

}
