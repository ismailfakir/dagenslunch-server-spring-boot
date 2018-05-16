package net.cloudcentrik.dagenslunch.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Restaurant r SET r.name = :name WHERE r.id = :id")
    int updateRestaurant(@Param("id") Long id, @Param("name") String name);

    /*@Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Restaurant r set " +
            "r.name = ?2," + "latitude = ?3," + "longitude = ?4," +
            "street = ?5," + "post_code = ?6, " + "city = ?7," + "country = ?8," +
            "email = ?9," + "password = ?10," + "telephone = ?11," + "opening_hours = ?12," +
            "category = ?13," + "rating = ?14," + "active = ?15," + "validity_date = ?16" +
            "where r.id = ?1")
    Integer updateRestaurantById(Long id, String name, Double latitude, Double longitude,
                                 String street, String postCode, String city, String country, String email,
                                 String password, String telephone, String openingHours, String category,
                                 int rating, boolean active, Date validityDate);*/
}
