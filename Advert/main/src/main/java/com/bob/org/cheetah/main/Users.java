package com.bob.org.cheetah.main;

import java.util.ArrayList;
import java.util.List;

public class Users{

    private List<String> tags = new ArrayList<String>();
    private String name = "";
    private int id = 0;

    public Users() {
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
