package models.storeModels;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static models.storeModels.Status.PLACED;
import static utilities.Randomizer.getRandomCompleteness;
import static utilities.Randomizer.getRandomNumber;

@Getter
@Builder
public class Order {
    @Builder.Default
    private int id = getRandomNumber();
    @Builder.Default
    private int petId = getRandomNumber();
    @Builder.Default
    private int quantity = getRandomNumber();
    @Builder.Default
    private String shipDate = Instant.now().toString();
    @Builder.Default
    private Status status = PLACED;
    @Builder.Default
    private Boolean complete = getRandomCompleteness();

}
