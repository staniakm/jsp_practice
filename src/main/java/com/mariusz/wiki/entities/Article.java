package com.mariusz.wiki.entities;

import com.mariusz.utils.DateTimeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;
    @Column
    @Convert(converter = DateTimeConverter.class)
    private LocalDateTime lastUpdate;
    @Column
    private String author;

    public String getUpdateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        return lastUpdate.format(formatter);

    }

}
