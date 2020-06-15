package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pet {

    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags tags[];
    private String status;


}
