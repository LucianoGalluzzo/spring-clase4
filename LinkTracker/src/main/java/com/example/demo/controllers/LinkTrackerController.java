package com.example.demo.controllers;

import com.example.demo.dto.LinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackerController {

    //instanciar un LinkDTO y agregarlo al Hashmap. Validar URL
    @PostMapping("/")
    public ResponseEntity createLink(@RequestBody LinkDTO url){
        return null;
    }

    //Buscar en el hashmap y validar el status el link y hacer toda la logica de redireccion y aumentar el contador
    @GetMapping("/link/{linkId}")
    public ResponseEntity redirectLink(@PathVariable Integer linkId){
        return null;
    }

    //Buscar en el hashmap y devolver el contador
    @GetMapping("metrics/{linkId}")
    public ResponseEntity getMetrics(@PathVariable Integer linkId){
        return null;
    }

    //Buscar en el hashmap y cambiar el status del link
    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable Integer linkId){
        return null;
    }

    

}
