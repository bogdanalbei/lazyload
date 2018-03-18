package com.ba4j.lazyload.repository;

import com.ba4j.lazyload.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<Long, User> users = new HashMap<>();
    private static final UserRepository instance = new UserRepository();
    private static final WalletRepository walletRepository = WalletRepository.getInstance();

    public static UserRepository getInstance() {
        return instance;
    }

    public User getById(long id) {
        System.out.println("UserRepository.getById(" + id + ") called");
        User user = users.get(id);
        user.setWallets(() -> walletRepository.getByUserId(id));

        return user;
    }

    public void addUsers(User... users) {
        for(User user: users) {
            this.users.put(user.getId(), user);
        }
    }
}
