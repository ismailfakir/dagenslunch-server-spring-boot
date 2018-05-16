package net.cloudcentrik.dagenslunch.controller;

import net.cloudcentrik.dagenslunch.exception.ResourceNotFoundException;
import net.cloudcentrik.dagenslunch.model.People;
import net.cloudcentrik.dagenslunch.repository.PeopleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RestController
@RequestMapping("/api")
public class PeopleController {

    @Autowired
    PeopleRepository peopleRepository;

    @GetMapping("/people")
    public List<People> retrieveAllPeoples() {
        return peopleRepository.findAll();
    }

    @PostMapping("/people")
    public People createPeople(@Valid @RequestBody People people) {
        return peopleRepository.save(people);
    }

    @PostMapping("/people/{id}")
    public int updatePeople(@PathVariable(value = "id") Long peopleId,@Valid @RequestBody People people) {

        return peopleRepository.updatePeople(peopleId,people.getFullName(),people.getJobTitle());
    }


    @GetMapping("/people/{id}")
    public Optional<People> getPeopleById(@PathVariable(value = "id") Long peopleId){

        //People people=peopleRepository.findOne(peopleId);
        Optional<People> people=peopleRepository.findById(peopleId);

        if (people == null) {
            throw new ResourceNotFoundException(peopleId,"People");
        }
        return people;
    }

    @DeleteMapping("/people/{id}")
    public void deletePeopleById(@PathVariable long id) {
        peopleRepository.deleteById(id);
    }

    @GetMapping("/people/title/{title}")
    public People findByJobTitle(@PathVariable(value = "title") String jobTitle){

        return peopleRepository.findByJobTitle(jobTitle);

    }


}
