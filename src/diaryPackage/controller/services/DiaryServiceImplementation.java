package services;

import dto.request.RegisterRequest;
import exceptions.DiaryNotFoundException;
import exceptions.EntryNotChangedException;
import exceptions.EntryNotFoundException;
import exceptions.IncorrectUsernameException;
import data.models.Diary;
import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.LoginRequest;
import dto.request.UpdateEntryRequest;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImplementation;
import repositories.EntryRepository;
import repositories.EntryRepositoryImplementation;

import java.util.List;

public class DiaryServiceImplementation implements DiaryService{


    private DiaryRepository diaryRepository = new DiaryRepositoryImplementation();
    private EntryRepository entryRepository = new EntryRepositoryImplementation();
    @Override
    public void registerUser(RegisterRequest registerRequest) {
        Diary diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryRepository.save(diary);
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

