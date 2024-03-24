package services;

import exceptions.EntryNotChangedException;
import exceptions.EntryNotFoundException;
import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.UpdateEntryRequest;
import repositories.EntryRepository;
import repositories.EntryRepositoryImplementation;

import java.util.List;

public class EntryServiceImplementation implements EntryService {
    private EntryRepository entryRepository = new EntryRepositoryImplementation();

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