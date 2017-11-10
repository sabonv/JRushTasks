package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by v.usov on 10.11.2017.
 */
public class ClientGuiModel {

    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public void addUser(String newUserName){

        if (!getAllUserNames().contains(newUserName)) allUserNames.add(newUserName);

    }

    public void deleteUser(String userName){
        if (getAllUserNames().contains(userName)) allUserNames.remove(userName);
    }  

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
}
