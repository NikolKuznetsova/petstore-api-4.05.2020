package models.petModels;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {
    @Builder.Default
    private long id = 3;
    @Builder.Default
    private String name = "domestic pet";

}
