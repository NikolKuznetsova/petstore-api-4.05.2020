package models.storeModels;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static models.storeModels.Status.PLACED;
import static utilities.Randomizer.getCompletenessFromList;
import static utilities.Randomizer.getOneOfTenNumbersFromList;

@Getter
@Builder
public class Order {
    @Builder.Default
    private int id = getOneOfTenNumbersFromList();
    @Builder.Default
    private int petId = getOneOfTenNumbersFromList();
    @Builder.Default
    private int quantity = getOneOfTenNumbersFromList();
    @Builder.Default
    private String shipDate = Instant.now().toString();
    @Builder.Default
    private Status status = PLACED;
    @Builder.Default
    private Boolean complete = getCompletenessFromList();

}
