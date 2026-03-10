package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeCreateDTO;
import ch.zhaw.avalanger.repository.AvalangeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/avalange")
public class AvalangeController {

    @Autowired
    private AvalangeRepository avlangeRepository;

    @GetMapping({"", "/{country}"})
    public ResponseEntity<List<Avalange>> getAllAvalanges(@PathVariable(required = false) String country, @RequestParam(required = false) String state) {
        
        if(country == null && state == null) {
            return new ResponseEntity<>(avlangeRepository.findAll(), HttpStatus.OK);
        } else if (country != null && state == null) {
            return new ResponseEntity<>(avlangeRepository.findByCountry(country), HttpStatus.OK);
        } else if (country == null && state != null) {
            return new ResponseEntity<>(avlangeRepository.findByState(ch.zhaw.avalanger.model.AvalangeState.valueOf(state)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(avlangeRepository.findbyCountryAndState(country, ch.zhaw.avalanger.model.AvalangeState.valueOf(state)), HttpStatus.OK);
        }
        
        
        
        
    
    }


    @PostMapping("")
    public ResponseEntity<String> postMethodName(@RequestBody AvalangeCreateDTO  avalangeDTO) {
        Avalange avalange = new Avalange(avalangeDTO.getCountry(), avalangeDTO.getDescription());
        avlangeRepository.save(avalange);
        return new ResponseEntity<>("Avalange created: " + avalangeDTO.getCountry() + ", " + avalangeDTO.getDescription(), HttpStatus.CREATED);
    }


    
    
}
