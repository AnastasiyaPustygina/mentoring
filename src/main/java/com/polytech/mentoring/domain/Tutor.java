package com.polytech.mentoring.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;


@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tutor")
@EqualsAndHashCode(callSuper = true)
public class Tutor extends Client{

    @Column(name = "subjects", nullable = false)
    private List<MentoringSubject>  subjects;

    @Column(name = "cost_info", nullable = false)
    private String costInfo;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<Comment> comments;

    @Column(name = "rating", nullable = false)
    private double rating;
}
