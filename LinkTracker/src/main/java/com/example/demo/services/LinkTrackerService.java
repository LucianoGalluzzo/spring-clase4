package com.example.demo.services;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exceptions.*;
import org.springframework.http.HttpHeaders;

import java.net.URISyntaxException;

public interface LinkTrackerService {

    ResponseDTO createLink (String url, String pwd) throws NotMatchURLException, ExistedURLException;
    HttpHeaders redirectLink (Integer linkId) throws URISyntaxException, InvalidLinkException;
    HttpHeaders redirectLink (Integer linkId, String pwd) throws InvalidPasswordException, URISyntaxException, InvalidLinkException;
    LinkDTO getMetrics(Integer linkId);
    String invalidateLink(Integer linkId) throws NotExistedURLException;
}
