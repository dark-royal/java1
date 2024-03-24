package diaryPackage.controller.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
@Data
public class Entry {


    private int id;
    private String body;
    private String title;
    private LocalDateTime dateCreated = LocalDateTime.now();


}


