package models.storeModels;

import lombok.Builder;
import lombok.Getter;

import static models.storeModels.Status.*;
import static utilities.Randomizer.*;

@Getter
@Builder
public class Order {
    @Builder.Default
    private int id = getRandomNumber();
    @Builder.Default
    private int petId = getRandomNumber();
    @Builder.Default
    private int quantity = getRandomNumber();
//    private static  Date date = Calendar.getInstance().getTime();
//    private static  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    @Builder.Default
    private String shipDate = "2020-07-06T12:43:29.648Z"; //dateFormat.format(date);
    @Builder.Default
    private Status status = PLACED;
    @Builder.Default
    private Boolean complete = getRandomCompleteness();
}
