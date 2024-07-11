package com.hackerrank.api.repository;

import com.hackerrank.api.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    @Query("" +
            "SELECT CASE WHEN COUNT(d) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Dog d " +
            "WHERE d.id = ?1"
    )
    Boolean selectExistsDog(Long id);
}
