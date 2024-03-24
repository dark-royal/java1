//package diaryPackage.controller.repositories;
//
//import diaryPackage.controller.data.models.Entry;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EntryRepositoryImplementation implements EntryRepository{
//    private List<Entry> entries = new ArrayList<>();
//    private  int id = 0;
//
//    @Override
//    public Entry save(Entry entry) {
//        entries.add(entry);
//        return entry;
//
//    }
//
//    @Override
//    public List<Entry> findAll() {
//        return entries;
//    }
//
//    @Override
//    public Entry findById(int id) {
//        for (Entry entry : entries) {
//            if (entry.getId() == id) {
//                return entry;
//            }
//
//        }
//        return null;
//
//    }
//
//    @Override
//    public long count() {
//        return entries.size();
//    }
//
//    @Override
//    public void delete(int id) {
//        Entry entry = findById(id);
//        entries.remove(entry);
//
//
//    }
//
//    @Override
//    public void delete(Entry entry) {
//        entries.remove(entry);
//
//
//    }
//
//    public int generateId(){
//        return ++id;
//    }
//
//
//
//}
//
