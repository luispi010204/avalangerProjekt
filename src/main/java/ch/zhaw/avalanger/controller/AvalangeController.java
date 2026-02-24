package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/avalange")
public class AvalangeController {

    @GetMapping({"", "/{country}"})
    public String getAllAvalanges(@PathVariable(required = false) String country, @RequestParam(required = false) String state) {
        if (country == null || country.isEmpty()) {
            return "No avalanges found";
        }
        return "No avalanges found for country: " + country + " and state: " + state;
    }


    @PostMapping("")
    public String postMethodName(@RequestBody Avalange  avalange) {
        
        
        return "Avalange received: " + avalange.getCountry() + ", " + avalange.getState() + ", " + avalange.getDescription();
    }
    





    
    
}
