package com.data.session_09.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seeds")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seed_name", nullable = false, unique = true)
    private String seedName;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
