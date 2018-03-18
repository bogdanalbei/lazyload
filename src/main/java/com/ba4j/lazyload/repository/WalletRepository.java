package com.ba4j.lazyload.repository;

import com.ba4j.lazyload.entity.Wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WalletRepository {
    private static final Map<Long, Wallet> wallets = new HashMap<>();
    private static final WalletRepository instance = new WalletRepository();

    public static WalletRepository getInstance() {
        return instance;
    }

    public List<Wallet> getByUserId(long userId) {
        System.out.println("WalletRepository.getByUserId(" + userId + ") called");
        return wallets.values().stream()
                .filter(wallet -> wallet.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public void addWallets(Wallet... wallets) {
        for(Wallet wallet: wallets) {
            this.wallets.put(wallet.getId(), wallet);
        }
    }
}
