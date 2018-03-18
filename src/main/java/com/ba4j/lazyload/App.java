package com.ba4j.lazyload;

import com.ba4j.lazyload.entity.User;
import com.ba4j.lazyload.entity.Wallet;
import com.ba4j.lazyload.repository.UserRepository;
import com.ba4j.lazyload.repository.WalletRepository;

import java.util.List;

public class App {
    private static final UserRepository userRepository = UserRepository.getInstance();
    private static final WalletRepository walletRepository = WalletRepository.getInstance();

    public static void main(String[] args) {
        initData();

        //get the user by id, this will not load the wallets
        User alex = userRepository.getById(1);
        System.out.println("Found Alex, the wallets are not loaded yet");

        //lazy load the wallets
        List<Wallet> alexsWallets = alex.getWallets();
        System.out.print("Alex's wallets: "+ alexsWallets);
    }

    private static void initData() {
        User john = new User(1, "Alex");
        User anna = new User(2, "Anna");
        userRepository.addUsers(john, anna);

        Wallet wallet1 = new Wallet(111, "ABC", john.getId());
        Wallet wallet2 = new Wallet(222, "BCD", john.getId());
        Wallet wallet3 = new Wallet(333, "XYZ", anna.getId());
        walletRepository.addWallets(wallet1, wallet2, wallet3);
    }
}
