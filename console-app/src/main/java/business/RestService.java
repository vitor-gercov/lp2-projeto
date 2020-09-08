/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Collections;

import dtos.Produto;
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

    private String url = "http://localhost:8080/produtos";

    public final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    
    public String getProducts() {
       
        return this.restTemplate.getForObject(this.url, String.class);
    }
    
    public String findProduct(String id){
        return this.restTemplate.getForObject(this.url + "/" + id, String.class);
    }
    
    public Produto postProduct(Produto produto) {

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
        return restTemplate.postForObject(this.url, entity, Produto.class);
    }

    public void updateProduct(String id,Produto produto) {

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        Produto putProduto = produto;

        // build the request
        HttpEntity<Produto> entity = new HttpEntity<>(putProduto, headers);

        // send PUT request to update post with `id` 10
        this.restTemplate.put(this.url + "/" + id, entity, id);
    }

    public void deleteProduct(String id) {

        // send DELETE request to delete post with `id` 10
        this.restTemplate.delete(this.url + "/" + id, 10);
    }
}
