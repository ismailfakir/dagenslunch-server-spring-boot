package net.cloudcentrik.dagenslunch.repository;

import net.cloudcentrik.dagenslunch.model.People;

import java.util.List;

public interface PeopleRepositoryCustom {
    List<People> getPeopleByJobTitleLike(String jobTitle);

}
