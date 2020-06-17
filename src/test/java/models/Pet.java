package models;

import Utilities.Randomizer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pet {
    @Builder.Default
    private long id = 0;
    @Builder.Default
    private Category category = Category.builder().build();
    @Builder.Default
    private String name = Randomizer.getRandomPetName();
    @Builder.Default
    private String[] photoUrls = new String[]{"https://media.nature.com/lw800/magazine-assets/d41586-020-01443-0/d41586-020-01443-0_17985512.jpg", "https://cs4.pikabu.ru/post_img/big/2014/05/21/5/1400654986_1651578960.jpg"};
    @Builder.Default
    private Tags tags[] = new Tags[]{Tags.builder().build()};
    @Builder.Default
    private String status = "available";


}
