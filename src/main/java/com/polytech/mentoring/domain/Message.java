package com.polytech.mentoring.domain;

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
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "text", nullable = false)
    private String text;
}
