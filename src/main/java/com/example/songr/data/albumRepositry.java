package com.example.songr.data;

import org.springframework.data.jpa.repository.JpaRepository;



public interface albumRepositry extends JpaRepository<album,Integer> {
    album findByid(int id);
}
