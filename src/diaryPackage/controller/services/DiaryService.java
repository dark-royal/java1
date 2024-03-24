package diaryPackage.controller.services;

import diaryPackage.controller.data.models.Diary;
import diaryPackage.controller.data.models.Entry;
import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.LoginRequest;
import diaryPackage.controller.request.UpdateEntryRequest;
import diaryPackage.controller.request.RegisterRequest;

import java.util.List;

public interface DiaryService {
    void registerUser(RegisterRequest registerRequest);
    void login(LoginRequest loginReques);
    void logout(String userName);
    List<Diary> getAll();

    Entry findEntry(String title);

    Entry createEntry(CreateEntryRequest createEntryRequest);

    Entry updateEntry(UpdateEntryRequest updateEntryRequest);

    Long count();
    int countEntries();
    void deleteEntry(String title);







}
