package diaryPackage.controller.exceptions;

public class EntryNotChangedException extends RuntimeException{
    public EntryNotChangedException(String message){
        super(message);
    }
}
