package diaryPackage.controller;

import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.LoginRequest;
import diaryPackage.controller.request.RegisterRequest;
import diaryPackage.controller.services.DiaryService;
import diaryPackage.controller.services.DiaryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryController {

    @Autowired
    private  DiaryService diaryService;
//    private final RegisterRequest registerRequest = new RegisterRequest();
//    private final LoginRequest loginRequest = new LoginRequest();
//    private final CreateEntryRequest createEntryRequest = new CreateEntryRequest();

    @PostMapping("/signUp")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            diaryService.registerUser(registerRequest);
            return "register successful";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            diaryService.login(loginRequest);
            return "login successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PatchMapping("/praise/{name}")
    public String logout(@PathVariable("name") String username) {
        try {
            diaryService.logout(username);
            return "logout successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/createEntry")
    public String createEntry(@RequestBody CreateEntryRequest createEntryRequest) {
        try {
            diaryService.createEntry(createEntryRequest);
            return "entry created successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/findEntry")
    public String findEntry(@RequestBody String title) {
        try {
            diaryService.findEntry(title);
            return "entry found successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
@DeleteMapping("/deleteEntry")
    public String deleteEntry(@RequestBody String title){
        try{
            diaryService.deleteEntry(title);
            return "entry deleted successfully";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @PostMapping("/getAll")
    public String getAll() {
        try {
            diaryService.getAll();
            return "all entry gotten already";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

