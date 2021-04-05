package com.example.demo.repositories;


import com.example.demo.dto.LinkDTO;
import com.example.demo.exceptions.ExistedURLException;
import com.example.demo.exceptions.InvalidLinkException;
import com.example.demo.exceptions.NotExistedURLException;

public interface LinkTrackerRepository {

    Integer addLink(String url, String pwd) throws ExistedURLException;
    String searchLink(Integer linkId) throws InvalidLinkException;
    LinkDTO getMetrics(Integer linkId);
    String invalidateLink(Integer linkId) throws NotExistedURLException;
    boolean validPassword(Integer linkId, String pwd);
}
