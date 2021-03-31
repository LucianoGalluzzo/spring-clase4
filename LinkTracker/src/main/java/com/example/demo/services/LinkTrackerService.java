package com.example.demo.services;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.ResponseDTO;
import org.springframework.http.HttpHeaders;

import java.net.URISyntaxException;

public interface LinkTrackerService {

    ResponseDTO createLink (String url);
    HttpHeaders redirectLink (Integer linkId) throws URISyntaxException;
    LinkDTO getMetrics(Integer linkId);
}
