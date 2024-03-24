package diaryPackage.controller.repositories;

import diaryPackage.controller.data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(int id);
    long count();
    void delete(int id);
    void delete(Entry entry);

}
