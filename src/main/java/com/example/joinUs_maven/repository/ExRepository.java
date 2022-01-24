package com.example.joinUs_maven.repository;

import com.example.joinUs_maven.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class ExRepository {
    private final EntityManager em;

    public void saveUser(User user){
        em.persist(user);
    }

    public User findUserByEmail(String email) {
        TypedQuery<User> query = em.createQuery("select m from User as m where m.email = ?1", User.class).setParameter(1, email);
        return query.getSingleResult();
    }
}