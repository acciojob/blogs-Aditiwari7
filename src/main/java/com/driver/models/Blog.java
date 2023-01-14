package com.driver.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bolgId;

    private String title;
    private String content;

    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;

    public Blog(){
    }

    public Blog(String title1, String content1, Date pubDate){
        this.title = title1;
        this.content = content1;
        this.pubDate = pubDate;
    }

    public int getBolgId() {
        return bolgId;
    }
    public void setBolgId(int bolgId) {
        this.bolgId = bolgId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }
    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}