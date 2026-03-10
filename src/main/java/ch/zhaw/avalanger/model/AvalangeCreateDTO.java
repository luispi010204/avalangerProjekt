package ch.zhaw.avalanger.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Document("avalanges")
public class AvalangeCreateDTO {
    
    private String country;
    private String description;

}
