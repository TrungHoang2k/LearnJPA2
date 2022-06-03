package com.stu.service.impl;

import com.stu.model.Blog;
import com.stu.repository.IBlogRepository;
import com.stu.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void remove(Integer id) {

    }
}
