package com.example.restmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="event_id")
    private Integer eventId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="cateory")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="place")
    private int place;

    @Column(name="cost")
    private int cost;
}
