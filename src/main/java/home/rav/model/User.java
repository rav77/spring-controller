package home.rav.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

    private int id;
    @NonNull private String name;
    @NonNull private int age;

}
