package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String description;
    private String dimension;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(){

    }

    public Image(String description, String dimension){
        this.description = description;
        this.dimension = dimension;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimension;
    }
    public void setDimensions(String dimension) {
        this.dimension = dimension;
    }


    public Blog getBlog() {
        return blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}