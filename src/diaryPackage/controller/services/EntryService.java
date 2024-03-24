package diaryPackage.controller.services;

import diaryPackage.controller.data.models.Entry;
import diaryPackage.controller.request.CreateEntryRequest;
import diaryPackage.controller.request.UpdateEntryRequest;

public interface EntryService {
    Entry createEntry(CreateEntryRequest createEntryRequest);

    void deleteEntry(int id);

    void updateEntry(UpdateEntryRequest updateEntryRequest);

    Entry findEntryById(int id);

    Long count();
}
