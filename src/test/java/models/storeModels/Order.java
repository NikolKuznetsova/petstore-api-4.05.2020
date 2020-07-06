package models.storeModels;

import Utilities.Randomizer;
import lombok.Builder;
import lombok.Getter;
import org.yecht.Data;

@Getter
@Builder
public class Order {
    @Builder.Default
    private int id = Randomizer.getRandomNumber();
    @Builder.Default
    private long petId = 0;
    @Builder.Default
    private int quantity = 0;
    @Builder.Default
    private String shipDate = "2020-07-06T12:43:29.648Z";
    @Builder.Default
    private String status = "placed";
    @Builder.Default
    private Boolean complete = true;
}
