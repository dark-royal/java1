package diaryPackage.controller;

import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.LoginRequest;
import diaryPackage.controller.request.RegisterRequest;
import diaryPackage.controller.services.DiaryService;
import diaryPackage.controller.services.DiaryServiceImplementation;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaryController {




        private final DiaryService diaryService = new DiaryServiceImplementation();
        private final RegisterRequest registerRequest = new RegisterRequest();
        private final LoginRequest loginRequest = new LoginRequest();
        private final CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        @PostMapping("/signUp")
        public String registerUser(@RequestBody RegisterRequest registerRequest) {
            try {
                diaryService.registerUser(registerRequest);
                return "request successfull";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        @PostMapping("/login")
        public String login(@RequestBody LoginRequest loginRequest){
            try{
                diaryService.login(loginRequest);
                return "login successfully";
            }catch (Exception e){
                return e.getMessage();
            }
        }
        @PatchMapping("/praise/{name}")
        public String logout(@PathVariable("name") String username){
            try{
                diaryService.logout(username);
                return "login successfully";
            }catch (Exception e){
                return e.getMessage();
            }
        }
@PostMapping("/createEntry")
        public String createEntry(@RequestBody CreateEntryRequest createEntryRequest){
            try{
                diaryService.createEntry(createEntryRequest);
                return "entry created successfully";
            }catch (Exception e){
                return e.getMessage();
            }
        }
    }

