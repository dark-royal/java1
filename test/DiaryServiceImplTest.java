
import diaryPackage.controller.request.LoginRequest;
import diaryPackage.controller.request.UpdateEntryRequest;
import diaryPackage.controller.request.RegisterRequest;
import diaryPackage.controller.services.DiaryService;
import diaryPackage.controller.data.models.Diary;
import diaryPackage.controller.data.models.Entry;
import diaryPackage.controller.services.DiaryServiceImplementation;
import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.exceptions.DiaryNotFoundException;
import diaryPackage.controller.exceptions.EntryNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
//
//public class DiaryServiceImplTest {
//    private DiaryService diaryService;
//    private RegisterRequest registerRequest;
//    private LoginRequest loginRequest;
//    private CreateEntryRequest createEntryRequest;
//    private Diary diary;
//
//
//    private UpdateEntryRequest updateEntryRequest;
//
//    @BeforeEach
//    public void initializer(){
//        diaryService = new DiaryServiceImplementation();
//        registerRequest = new RegisterRequest();
//        loginRequest = new LoginRequest();
//        diary = new Diary();
//        createEntryRequest = new CreateEntryRequest();
//        updateEntryRequest = new UpdateEntryRequest();
//
//    }
//
//
//
//    @Test
//    public void userCanRegisterCustomer(){
//
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1,diaryService.count());
//    }
//
//    @Test
//    public void userCanLogin(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1,diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//
//    }
//
//    @Test
//    public void userCan_register_login_andlogout() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        diaryService.logout("username");
//        assertFalse(diary.setLogStatus(false));
//    }
//
//
//    @Test
//    public void testUserCannotLoginWithIncorrectUsernameOrPassword(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username1");
//        loginRequest.setPassword("password");
//        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));
//
//
//    }
//    @Test
//    public void test_user_cannot_login_while_not_registered_throw_diary_not_found_exception(){
//        loginRequest.setUsername(loginRequest.getUsername());
//        loginRequest.setPassword(loginRequest.getPassword());
//        assertThrows(DiaryNotFoundException.class,()->diaryService.login(loginRequest));
//
//    }
//
//    @Test
//    public void userCan_register_login_andlogout_with_incorrect_username() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        assertThrows(DiaryNotFoundException.class,()->diaryService.logout("username1"));
//        assertTrue(diary.setLogStatus(true));
//    }
//
//    @Test
//    public void userCanRegister_Login_createEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//
//
//    }
//
//    @Test
//    public void userCanRegister_Login_createEntry_andCanUpdateTheEntry() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        Entry entyr1 = diaryService.createEntry(createEntryRequest);
//        assertEquals(1, diaryService.count());
//        updateEntryRequest.setTitle("semicolon");
//        updateEntryRequest.setBody("change");
//        diaryService.updateEntry(updateEntryRequest);
//        //System.out.println(STR."\{updateRequest.getId()} nothing");
//        assertEquals("semicolon", diaryService.updateEntry(updateEntryRequest));
//        assertEquals("change",diaryService.updateEntry(updateEntryRequest));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry,diaryService.findEntry("semicolon"));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_deleteEntry(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry,diaryService.findEntry("semicolon"));
//        diaryService.deleteEntry("semicolon");
//        assertEquals(0,diaryService.countEntries());
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntryWithIncorrectPassword(){
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1,diaryService.count());
//        assertThrows(EntryNotFoundException.class,()->diaryService.findEntry("semicoloni"));
//
//
//    }
//
//    @Test
//    public void userCanRegister_login_createEntry_findEntry_deleteEntryWithIncorrectPassword() {
//        registerRequest.setUsername("username");
//        registerRequest.setPassword("password");
//        diaryService.registerUser(registerRequest);
//        assertEquals(1, diaryService.count());
//        loginRequest.setUsername("username");
//        loginRequest.setPassword("password");
//        diaryService.login(loginRequest);
//        assertTrue(diary.setLogStatus(true));
//        createEntryRequest.setTitle("semicolon");
//        createEntryRequest.setBody("i love semicolon");
//        System.out.println(createEntryRequest.getDateAndTimeCreated());
//        diaryService.createEntry(createEntryRequest);
//        assertEquals(1, diaryService.count());
//        Entry entry = diaryService.findEntry("semicolon");
//        assertEquals(entry, diaryService.findEntry("semicolon"));
//        assertThrows(EntryNotFoundException.class,()->diaryService.deleteEntry("semicoloni"));
//    }
//
//
//
//
//}
//
//
