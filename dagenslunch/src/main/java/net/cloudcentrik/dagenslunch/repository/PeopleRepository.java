package net.cloudcentrik.dagenslunch.repository;

import net.cloudcentrik.dagenslunch.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Transactional
    @Query(value = "SELECT * FROM People WHERE jobTitle = ?1", nativeQuery = true)
    People findByJobTitle(String jobTitle);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE People p SET p.fullName = :Name, p.jobTitle = :Job WHERE p.id = :Id")
    int updatePeople(@Param("Id") long id, @Param("Name") String name,@Param("Job") String job);


}
