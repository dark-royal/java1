package services;

import data.models.Entry;
import dto.request.CreateEntryRequest;
import dto.request.UpdateEntryRequest;

import java.util.List;

public interface EntryService {
    Entry createEntry(CreateEntryRequest createEntryRequest);

    void deleteEntry(int id);

    void updateEntry(UpdateEntryRequest updateEntryRequest);

    Entry findEntryById(int id);

    Long count();
}
