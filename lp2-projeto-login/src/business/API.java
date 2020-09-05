/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Usuario
 */
public class API {
    public Post createPost() {
    String url = "https://jsonplaceholder.typicode.com/posts";

    // create headers
    HttpHeaders headers = new HttpHeaders();
    // set `content-type` header
    headers.setContentType(MediaType.APPLICATION_JSON);
    // set `accept` header
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

    // create a map for post parameters
    Map<String, Object> map = new HashMap<>();
    map.put("userId", 1);
    map.put("title", "Introduction to Spring Boot");
    map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

    // build the request
    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

    // send POST request
    ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);

    // check response status code
    if (response.getStatusCode() == HttpStatus.CREATED) {
        return response.getBody();
    } else {
        return null;
    }
}
}
