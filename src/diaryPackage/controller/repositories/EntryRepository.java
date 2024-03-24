package diaryPackage.controller.repositories;

import diaryPackage.controller.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntryRepository extends MongoRepository<Entry, String> {


}
