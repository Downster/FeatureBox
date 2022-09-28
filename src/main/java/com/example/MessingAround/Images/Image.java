package com.example.MessingAround.Images;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="Images")
public class Image {
    private @Id @GeneratedValue Long id;
    private String description;
    private String url;
    private String owner;

    public Image(String description, String url, String owner){
        this.description = description;
        this.url = url;
        this.owner = owner;
    }

    public Image() {}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(description, image.description) &&
                Objects.equals(url, image.url) &&
                Objects.equals(owner, image.owner);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, description, url, owner);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Image{" +
                "id=" + id + '\'' +
                "description=" + description + '\'' +
                "url=" + url + '\'' +
                "owner=" + owner + "}";
    }
}
