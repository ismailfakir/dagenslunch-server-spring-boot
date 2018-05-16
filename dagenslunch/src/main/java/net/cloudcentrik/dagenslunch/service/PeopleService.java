package net.cloudcentrik.dagenslunch.service;

import net.cloudcentrik.dagenslunch.model.People;
import net.cloudcentrik.dagenslunch.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PeopleService{

    @Autowired
    PeopleRepository peopleRepository;

    public List<People> findAllPeople() {
        return peopleRepository.findAll();
    }
}
