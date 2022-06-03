package com.stu.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;
    @Column(name = "blog_name")
    private String name;
    @Column(name = "blog_short_content")
    private String shortContent;
    @Column(name = "blog_full_content")
    private String fullContent;

    public Blog() {
    }

    public Blog(Integer id, String name, String shortContent, String fullContent) {
        this.id = id;
        this.name = name;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }
}
