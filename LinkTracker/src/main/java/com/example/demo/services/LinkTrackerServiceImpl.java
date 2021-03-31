package com.example.demo.services;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.repositories.LinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService{

    @Autowired
    private LinkTrackerRepository linkTrackerRepository;

    @Override
    public ResponseDTO createLink(String url) {
        return new ResponseDTO(linkTrackerRepository.addLink(url));
    }

    @Override
    public HttpHeaders redirectLink(Integer linkId) throws URISyntaxException {

        String url = linkTrackerRepository.searchLink(linkId);
        URI uri = new URI(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return httpHeaders;
    }

    @Override
    public LinkDTO getMetrics(Integer linkId) {
        return linkTrackerRepository.getMetrics(linkId);
    }
}
