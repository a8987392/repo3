package boot.myclasses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
    private int id;
    private String name;
    private  float price;
    private String author;



}
