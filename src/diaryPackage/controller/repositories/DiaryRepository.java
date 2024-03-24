package diaryPackage.controller.repositories;

import diaryPackage.controller.data.models.Diary;
import diaryPackage.controller.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DiaryRepository extends MongoRepository<Diary,String> {
    Diary findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);
}
