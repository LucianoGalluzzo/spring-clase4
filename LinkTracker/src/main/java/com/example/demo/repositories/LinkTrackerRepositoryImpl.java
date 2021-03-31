package com.example.demo.repositories;

import com.example.demo.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkTrackerRepositoryImpl implements LinkTrackerRepository{

    private AtomicInteger contadorId = new AtomicInteger(1);

    private Map<Integer, LinkDTO> listURL;

    public LinkTrackerRepositoryImpl() {
        this.listURL = new HashMap<>();
    }

    @Override
    public Integer addLink(String url) {

        //Validar URL
        listURL.put(contadorId.get(), new LinkDTO(url));
        return contadorId.getAndIncrement();
    }

    @Override
    public String searchLink(Integer linkId) {
        listURL.get(linkId).setContador(listURL.get(linkId).getContador() + 1);
        return listURL.get(linkId).getUrl();
    }

    @Override
    public LinkDTO getMetrics(Integer linkId) {
        return listURL.get(linkId);
    }
}
