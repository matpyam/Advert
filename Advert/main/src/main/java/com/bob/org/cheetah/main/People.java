package com.bob.org.cheetah.main;

import java.util.ArrayList;
import java.util.List;

public class People {
    private List<Users> recipients = new ArrayList<Users>();
    
    public List<Users> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Users> recipients) {
        this.recipients = recipients;
    }

    public People() {
    }

    
}
