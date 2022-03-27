package com.example.songr.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface songRepsoitry extends JpaRepository<song,Integer> {

}
