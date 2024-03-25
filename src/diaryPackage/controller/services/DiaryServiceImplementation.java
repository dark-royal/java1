package diaryPackage.controller.services;

import diaryPackage.controller.request.RegisterRequest;
import diaryPackage.controller.exceptions.DiaryNotFoundException;
import diaryPackage.controller.exceptions.EntryNotChangedException;
import diaryPackage.controller.exceptions.EntryNotFoundException;
import diaryPackage.controller.exceptions.IncorrectUsernameException;
import diaryPackage.controller.data.models.Diary;
import diaryPackage.controller.data.models.Entry;
import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.LoginRequest;
import diaryPackage.controller.request.UpdateEntryRequest;
import diaryPackage.controller.repositories.DiaryRepository;
import diaryPackage.controller.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DiaryServiceImplementation implements DiaryService{

    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    public void YourServiceClassName(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }
    @Override
    public void registerUser(RegisterRequest registerRequest) {
        validate(registerRequest.getUsername());
            Diary diary = new Diary();
            diary.setUsername(registerRequest.getUsername());
            diary.setPassword(registerRequest.getPassword());
            diaryRepository.save(diary);
    }

    public void validate(String username) {
        if (diaryRepository.existsById(username)) throw new UsernameExistException("%s already exist", username);
    }

    @Override
    public void login(LoginRequest loginRequest) {
        Diary diary = diaryRepository.findByUsername(loginRequest.getUsername());
        if(diary == null)throw new DiaryNotFoundException("diary not found");
        if (!diary.getUsername().equalsIgnoreCase(loginRequest.getUsername()) && diary.getPassword().equalsIgnoreCase(loginRequest.getPassword()))throw new IncorrectUsernameException("invalid username or password");
        else {
            diary.setLogStatus(true);
        }
    }
    public void logout(String userName) {
        Diary diary = diaryRepository.findByUsername(userName);
        diary.setLogStatus(false);
        diaryRepository.save(diary);
    }

    @Override
    public List<Diary> getAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Entry createEntry(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        entry.setDateCreated(createEntryRequest.getDateAndTimeCreated());
        entry.setId((int)entryRepository.count() + 1);
        return entryRepository.save(entry);
    }

    public Entry updateEntry(UpdateEntryRequest updateRequest) {
        String title = updateRequest.getTitle();
        String body = updateRequest.getBody();
        Entry entry = findEntry(title);
        if(entry.getBody().equals(body)){
            throw new EntryNotChangedException("entry was not updated");
        }
        entry.setTitle(updateRequest.getTitle());
        entry.setBody(updateRequest.getBody());
        entry.setId(updateRequest.getId());
        entryRepository.save(entry);
        return entry;
    }

    public Entry findEntry(String title) {
        for (Entry entry: entryRepository.findAll()){
            if(entry.getTitle().equalsIgnoreCase(title)){
                return entry;
            }
        }
        throw new EntryNotFoundException("entry not found");
    }

    public void deleteEntry(String title){
        Entry entry = findEntry(title);
        entryRepository.delete(entry);


    }

    @Override
    public Long count() {
        return diaryRepository.count();
    }
    public int countEntries(){
        return (int)entryRepository.count();
    }


}

