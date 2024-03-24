package diaryPackage.controller.exceptions;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(String message){
        super(message);
    }
}
