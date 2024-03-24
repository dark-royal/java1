package diaryPackage.controller.services;

import diaryPackage.controller.exceptions.EntryNotChangedException;
import diaryPackage.controller.exceptions.EntryNotFoundException;
import diaryPackage.controller.data.models.Entry;
import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.UpdateEntryRequest;
import diaryPackage.controller.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImplementation implements EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry createEntry(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        entry.setDateCreated(createEntryRequest.getDateAndTimeCreated());
        entry.setId((int) entryRepository.count() + 1);
        return entryRepository.save(entry);

    }

    @Override
    public void deleteEntry(int id) {


    }

    @Override
    public void updateEntry(UpdateEntryRequest updateRequest) {
        String title = updateRequest.getTitle();
        String body = updateRequest.getBody();
        Entry entry = findEntry(title);
        if (entry.getBody().equals(body)) {
            throw new EntryNotChangedException("entry was not updated");
        }
        entry.setTitle(updateRequest.getTitle());
        entry.setBody(updateRequest.getBody());
        entry.setId(updateRequest.getId());
        entryRepository.save(entry);

    }

    private Entry findEntry(String title) {
        for (Entry entry : entryRepository.findAll()) {
            if (entry.getTitle().equalsIgnoreCase(title)) {
                return entry;
            }
        }
        throw new EntryNotFoundException("entry not found");

    }

    @Override
    public Entry findEntryById(int id) {
        for (Entry entry : entryRepository.findAll()) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        throw new EntryNotFoundException("entry not found");
    }

    @Override
    public Long count() {
        return entryRepository.count();
    }
}