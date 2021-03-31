package com.example.demo.repositories;


import com.example.demo.dto.LinkDTO;

public interface LinkTrackerRepository {

    Integer addLink(String url);
    String searchLink(Integer linkId);
    LinkDTO getMetrics(Integer linkId);
}
