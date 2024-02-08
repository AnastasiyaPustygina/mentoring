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
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date", nullable = false)
    private String date;
}
