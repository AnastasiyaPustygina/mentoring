package com.polytech.mentoring.domain.chat;

import com.polytech.mentoring.domain.Client;
import com.polytech.mentoring.domain.Marker;
import com.polytech.mentoring.domain.Message;
import com.polytech.mentoring.domain.enums.ActivityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forum")
public class Forum {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "forum_client", joinColumns = @JoinColumn(name = "forum_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> people;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "forum_marker", joinColumns = @JoinColumn(name = "forum_id"),
            inverseJoinColumns = @JoinColumn(name = "marker_id"))
    private List<Marker> markers;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "forum")
    private List<Message> messages;
}
