package models.petModels;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Tags {
    @Builder.Default
    private long id = 1;
    @Builder.Default
    private String name = "zoo";


}
