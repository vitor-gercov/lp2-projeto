/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Collections;

import models.Produto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author oseas
 */
@Service
public class RestService {

    public final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Produto createPostWithObject(Produto produto) {
        String url = "http://localhost:8080/produtos";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        Produto postPrdouto = produto;
        
        System.out.println(postPrdouto);
        // build the request
        HttpEntity<Produto> entity = new HttpEntity<>(postPrdouto, headers);

        // send POST request
        return restTemplate.postForObject(url, entity, Produto.class);
    }
}
