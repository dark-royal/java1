package diaryPackage.controller.data.models;

import jakarta.annotation.Generated;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Diary {
    private int id = 1;
    private  String username;
    private  String password;
    private boolean logStatus;


}



