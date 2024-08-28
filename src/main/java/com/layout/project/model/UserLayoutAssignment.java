package com.layout.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_layout_assignment")
public class UserLayoutAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_group_id", referencedColumnName = "id")
    private UserGroup userGroup;

    @ManyToOne
    @JoinColumn(name = "layout_id", referencedColumnName = "id")
    private Layout layout;
}
