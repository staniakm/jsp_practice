package com.mariusz.wiki.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Content() {
    }

    public Content(String content) {
        this.content = content;
    }

    public String getShortContent(){
        if (content.length()>300){
            return content.substring(0,300);
        }else {
            return content;
        }
    }
}
