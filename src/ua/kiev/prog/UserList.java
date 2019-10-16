package ua.kiev.prog;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList classUserList = new UserList();
    private  List<User> userList;
    private Gson gson = new Gson();

    private UserList() {
        userList = new ArrayList<>();
    }

    public static UserList getInstance() {
        return classUserList;
    }

    public  List<User> getUserList() {
        return userList;
    }
    public String toJson(){
        return gson.toJson(userList);
    }
}
