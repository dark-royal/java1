package diaryPackage.controller.exceptions;

public class IncorrectUsernameException extends RuntimeException{
    public IncorrectUsernameException(String message){
        super(message);
    }
}
