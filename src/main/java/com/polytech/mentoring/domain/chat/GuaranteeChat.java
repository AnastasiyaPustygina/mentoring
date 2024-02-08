package com.polytech.mentoring.domain.chat;

import com.polytech.mentoring.domain.Client;
import com.polytech.mentoring.domain.Guarantee;
import com.polytech.mentoring.domain.Message;
import com.polytech.mentoring.domain.Tutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guarantee_chat")
public class GuaranteeChat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(targetEntity = Tutor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne(targetEntity = Guarantee.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "guarantee_id")
    private Guarantee guarantee;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "forum")
    private List<Message> messages;
}
