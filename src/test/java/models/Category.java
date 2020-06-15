package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {
    private long id;
    private String name;

}
