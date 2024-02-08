package com.polytech.mentoring.domain.chat;

import com.polytech.mentoring.domain.Client;
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
@Table(name = "chat")
public class PrivateChat {

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

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "chat")
    private List<Message> messages;
}
