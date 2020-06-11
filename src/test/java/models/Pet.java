package models;

import models.Category;

public class Pet {

    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags tags[];
    private String status;

    public Pet(long id, String name, String status) {
        this.id = id;
        this.category = new Category(3, "animals");
        this.name = name;
        this.photoUrls = new String[] {"https://media.nature.com/lw800/magazine-assets/d41586-020-01443-0/d41586-020-01443-0_17985512.jpg", "https://cs4.pikabu.ru/post_img/big/2014/05/21/5/1400654986_1651578960.jpg"};
        this.tags = new Tags[2];
        tags[0] = new Tags(1, "domestic");
        tags[1] = new Tags(2, "pets");
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Object getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Object[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }


}
