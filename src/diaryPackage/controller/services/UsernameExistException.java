package diaryPackage.controller.services;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException(String usernameAlreadyExists, String username) {
        super(usernameAlreadyExists);
    }
}
