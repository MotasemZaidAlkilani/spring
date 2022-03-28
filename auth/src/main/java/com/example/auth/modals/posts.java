package com.example.auth.modals;

import javax.persistence.*;

@Entity
public class posts {
    @Id
    @GeneratedValue
    private Long id;

   @ManyToOne
   @JoinColumn(name = "user_id")
   LoginUser user;

    public LoginUser getUser() {
        return user;
    }

    private String text_content;

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }
}
