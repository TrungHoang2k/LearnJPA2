package com.stu.repository.impl;

import com.stu.model.Blog;
import com.stu.model.Customer;
import com.stu.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Integer id) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where  b.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void remove(Integer id) {

    }
}
