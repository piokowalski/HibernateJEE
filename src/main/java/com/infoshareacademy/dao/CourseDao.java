package com.infoshareacademy.dao;

import com.infoshareacademy.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(Course s) {
        entityManager.persist(s);
        return s.getName();
    }

    public Course update(Course s) {
        return entityManager.merge(s);
    }

    public void delete(String name) {
        final Course s = entityManager.find(Course.class, name);
        if (s != null) {
            entityManager.remove(s);
        }
    }

    public Course findByName(String name) {
        return entityManager.find(Course.class, name);
    }

    public List<Course> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Course s");

        return query.getResultList();
    }

}