package be.faros.hiberstraps.demo.repository;

import be.faros.hiberstraps.demo.domain.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    private final EntityManager em;

    public CourseRepository(EntityManager em) {
        this.em = em;
    }

    public List<Course> findCoursesByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> query = cb.createQuery(Course.class);

        Root<Course> root = query.from(Course.class);

        Path<Object> namePath = root.get("name");

        Predicate test = cb.equal(namePath, name);

        query.where(test);

        TypedQuery<Course> tq = em.createQuery(query);

        return tq.getResultList();
    }
}
