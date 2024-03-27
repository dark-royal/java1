package diaryPackage.controller.services;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String message){
        super(message);
    }
}
