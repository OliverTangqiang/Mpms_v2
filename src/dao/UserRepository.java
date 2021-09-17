package dao;

import connector.DbConnector;
import model.User;

import java.awt.*;
import java.util.ArrayList;

public class UserRepository {
    private DbConnector dbConnector;
    private ArrayList<User> users;

    public UserRepository() {
        dbConnector = new DbConnector("user.txt");
        users = new ArrayList<>();

    }

    public UserRepository(DbConnector dbConnector, ArrayList<User> users) {
        this.dbConnector = dbConnector;
        this.users = users;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void loadUserData() {
        ArrayList<String> userStringArrayList = dbConnector.readDataFromFile();
        for (String line: userStringArrayList)
        {
            // test1@test.com.au,123456,Daniel,Deng,M,26
            String[] lineArraySplitByComma = line.split(",");
            User user = new User(lineArraySplitByComma[0],
                    lineArraySplitByComma[1],
                    lineArraySplitByComma[2],
                    lineArraySplitByComma[3],
                    lineArraySplitByComma[4].charAt(0),
                    Integer.parseInt(lineArraySplitByComma[5]));
            users.add(user);
        }
    }

    public User selectUserByEmailAndPassword(String email, String password){
        loadUserData();
        for (User user : users)
        {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }
}
