package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    @Autowired
    private BlogRepository IblogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        Image image = new Image(description, dimensions);
        image.setBlog(blog);

        List<Image> imageList = blog.getImageList();
        if(imageList == null) imageList = new ArrayList<>();

        imageList.add(image);
        blog.setImageList(imageList);
        imageRepository2.save(image);
        IblogRepository.save(blog);
        return image;
    }

    public void deleteImage(Image image){
        imageRepository2.delete(image);
    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        if(screenDimensions.split("X").length==2 || Objects.nonNull(image)){
            Integer maxLength = Integer.parseInt(screenDimensions.split("X")[0]) / Integer.parseInt(image.getDimension().split("X")[0]);
            Integer maxBreath = Integer.parseInt(screenDimensions.split("X")[1]) / Integer.parseInt(image.getDimension().split("X")[1]);
            return maxLength * maxBreath;
        }
        return 0;
    }
}
