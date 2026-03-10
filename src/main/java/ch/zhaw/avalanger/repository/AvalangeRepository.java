package ch.zhaw.avalanger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeState;

import java.util.List;


public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountry(String country);
    List<Avalange> findByState(AvalangeState state);
    List<Avalange>findbyCountryAndState(String country, AvalangeState state);
    
}
