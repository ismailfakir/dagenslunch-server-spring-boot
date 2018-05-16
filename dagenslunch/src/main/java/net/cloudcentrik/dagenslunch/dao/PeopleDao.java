package net.cloudcentrik.dagenslunch.dao;

import net.cloudcentrik.dagenslunch.model.People;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PeopleDao {
    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Return all the people stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<People> getAll() {
        return entityManager.createQuery("from People").getResultList();
    }
}

