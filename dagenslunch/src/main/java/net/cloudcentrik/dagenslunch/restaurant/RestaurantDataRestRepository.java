package net.cloudcentrik.dagenslunch.restaurant;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "restaurant", collectionResourceRel = "Restaurant")
public interface RestaurantDataRestRepository extends PagingAndSortingRepository<Restaurant, Long>{

}
