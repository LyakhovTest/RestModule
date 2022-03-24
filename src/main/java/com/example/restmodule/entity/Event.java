package com.example.restmodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="event")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "place")
    private String place;
    @Column(name = "speaker")
    private String speaker;
    @Column(name = "eventType")
    private String eventType;
    @Column(name = "date_time")
    private Instant dateTime;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Event event = (Event) o;
//        return Objects.equals(id, event.id) && Objects.equals(title, event.title) && Objects.equals(place, event.place) && Objects.equals(speaker, event.speaker) && Objects.equals(eventType, event.eventType);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, place, speaker, eventType);
//    }
}
