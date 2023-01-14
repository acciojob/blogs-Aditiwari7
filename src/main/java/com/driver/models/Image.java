package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(){

    }

    public Image(String description, String dimension){
        this.description = description;
        this.dimensions = dimension;
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
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}