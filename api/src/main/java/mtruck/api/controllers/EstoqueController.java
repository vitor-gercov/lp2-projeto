/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GERU\christian.seki
 */
@RestController
public class EstoqueController {
    
    @GetMapping("estoque")
    public String estoque(@RequestParam(value = "item", defaultValue = "default") String name) {
    return String.format("<h1>Item: %s</h1>", name);
    }
}
