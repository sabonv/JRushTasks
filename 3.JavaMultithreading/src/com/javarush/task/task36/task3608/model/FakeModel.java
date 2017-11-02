package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by v.usov on 02.11.2017.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        List<User> temp = new LinkedList<User>();

        temp.add(new User("Test1", 2, 777));
        temp.add(new User("Test2", 1, 777));

        modelData.setUsers(temp);

    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
