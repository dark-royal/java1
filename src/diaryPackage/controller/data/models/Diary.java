package diaryPackage.controller.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Diary {
    private  String username;
    private  String password;
    private int id = 0;
    private boolean logStatus;


}



