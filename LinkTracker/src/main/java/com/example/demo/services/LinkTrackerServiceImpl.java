package com.example.demo.services;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exceptions.*;
import com.example.demo.repositories.LinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService{

    @Autowired
    private LinkTrackerRepository linkTrackerRepository;

    @Override
    public ResponseDTO createLink(String url, String pwd) throws NotMatchURLException, ExistedURLException {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(url);
        boolean matcherFound = matcher.find();
        if(matcherFound)
            return new ResponseDTO(linkTrackerRepository.addLink(url, pwd));
        else
            throw new NotMatchURLException(url);
    }

    @Override
    public HttpHeaders redirectLink(Integer linkId) throws URISyntaxException, InvalidLinkException {

        String url = linkTrackerRepository.searchLink(linkId);
        URI uri = new URI(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return httpHeaders;
    }

    @Override
    public HttpHeaders redirectLink(Integer linkId, String pwd) throws URISyntaxException, InvalidLinkException, InvalidPasswordException {

        if(linkTrackerRepository.validPassword(linkId, pwd)){
            String url = linkTrackerRepository.searchLink(linkId);
            URI uri = new URI(url);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return httpHeaders;
        }else
            throw new InvalidPasswordException(linkId, pwd);
    }

    @Override
    public LinkDTO getMetrics(Integer linkId) {
        return linkTrackerRepository.getMetrics(linkId);
    }

    @Override
    public String invalidateLink(Integer linkId) throws NotExistedURLException {
        return linkTrackerRepository.invalidateLink(linkId);
    }
}
