package controller;

import dao.UserRepository;

public class UserController {
    private UserRepository userRepository;

    public UserController(){
        userRepository = new UserRepository();
    }



    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateEmailAndPassword(String email, String password) {
        return userRepository.selectUserByEmailAndPassword(email, password) !=null;
    }


}
