package com.example.demo.controllers;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.services.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class LinkTrackerController {

    @Autowired
    private LinkTrackerService linkTrackerService;

    //instanciar un LinkDTO y agregarlo al Hashmap. Validar URL
    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createLink(@RequestBody LinkDTO url){

        return new ResponseEntity<>(linkTrackerService.createLink(url.getUrl()), HttpStatus.OK);
    }

    //Buscar en el hashmap y validar el status el link y hacer toda la logica de redireccion y aumentar el contador
    @GetMapping("/link/{linkId}")
    public ResponseEntity<HttpHeaders> redirectLink(@PathVariable Integer linkId) throws URISyntaxException {
            return new ResponseEntity<>(linkTrackerService.redirectLink(linkId), HttpStatus.SEE_OTHER);
    }

    //Buscar en el hashmap y devolver el contador
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDTO> getMetrics(@PathVariable Integer linkId){

        return new ResponseEntity<>(linkTrackerService.getMetrics(linkId), HttpStatus.OK);
    }

    //Buscar en el hashmap y cambiar el status del link
    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable Integer linkId){
        return null;
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ErrorDTO> notFoundIngredientException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO("Invalid Ingredient", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    

}
