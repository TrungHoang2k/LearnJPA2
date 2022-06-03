package com.stu.controller;

import com.stu.model.Blog;
import com.stu.model.Customer;
import com.stu.service.IBlogService;
import com.stu.service.ICustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private final IBlogService service;


    public BlogController(IBlogService service) {
        this.service = service;
    }

    @GetMapping("/blogs")
    public ModelAndView showList(){
        List<Blog> blogs = service.findAll();
        ModelAndView mav = new ModelAndView("/blog/list");
        mav.addObject("blogs", blogs);
        return mav;
    }

    @GetMapping("/create-form")
    public ModelAndView creatForm(Model model){
        ModelAndView mav = new ModelAndView("/blog/create");
        mav.addObject("blog",new Blog());
        return mav;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog){
        service.save(blog);
        ModelAndView mav = new ModelAndView("/blog/create");
        mav.addObject("blog", new Blog());
        mav.addObject("message","Create successfully");
        return mav;
    }
    @GetMapping("/edit-form/{id}")
    public ModelAndView createForm(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("/blog/create");
        Blog blog = service.findById(id);
        mav.addObject("blog",new Blog());
        return mav;
    }
}
