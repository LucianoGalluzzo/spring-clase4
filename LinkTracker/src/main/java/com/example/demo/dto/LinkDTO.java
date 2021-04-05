package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {

    private String url;
    private boolean valid;
    private Integer contador;
    private String pwd;

    public LinkDTO(String url, String pwd){
        this.url = url;
        contador = 0;
        valid = true;
        this.pwd = pwd;
    }

    public void increment(){
        contador++;
    }

    @Override
    public boolean equals(Object linkDTO){
        return this.getUrl().equals(((LinkDTO) linkDTO).getUrl());
    }
}
