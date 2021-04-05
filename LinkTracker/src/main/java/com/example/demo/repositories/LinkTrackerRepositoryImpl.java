package com.example.demo.repositories;

import com.example.demo.dto.LinkDTO;
import com.example.demo.exceptions.ExistedURLException;
import com.example.demo.exceptions.InvalidLinkException;
import com.example.demo.exceptions.NotExistedURLException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkTrackerRepositoryImpl implements LinkTrackerRepository{

    private final AtomicInteger contadorId = new AtomicInteger(1);

    private final Map<Integer, LinkDTO> listURL;

    public LinkTrackerRepositoryImpl() {
        this.listURL = new HashMap<>();
    }

    @Override
    public Integer addLink(String url, String pwd) throws ExistedURLException {

        LinkDTO linkDTO = new LinkDTO(url, pwd);
        if(!listURL.containsValue(linkDTO)){
            listURL.put(contadorId.get(), new LinkDTO(url, pwd));
            return contadorId.getAndIncrement();
        }
        throw new ExistedURLException("url");

    }

    @Override
    public String searchLink(Integer linkId) throws InvalidLinkException {
        LinkDTO linkDTO = listURL.get(linkId);
        if(linkDTO != null){
            if(linkDTO.isValid()){
                linkDTO.increment();
                return linkDTO.getUrl();
            }else
                throw new InvalidLinkException(linkId);
        }
        else{
            return "";
        }
    }

    @Override
    public LinkDTO getMetrics(Integer linkId) {
        return listURL.get(linkId);
    }

    @Override
    public String invalidateLink(Integer linkId) throws NotExistedURLException {
        if(listURL.containsKey(linkId)){
            listURL.get(linkId).setValid(false);
            return "URL " + listURL.get(linkId).getUrl() + " succesfully invalidated";
        }else
            throw new NotExistedURLException(linkId);
    }

    @Override
    public boolean validPassword(Integer linkId, String pwd) {

        if(listURL.get(linkId).getPwd().equals(pwd)){
            return true;
        }else{
            return false;
        }
    }
}
