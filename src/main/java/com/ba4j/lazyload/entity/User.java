package com.ba4j.lazyload.entity;

import java.util.List;
import java.util.function.Supplier;

public class User {
    private long id;
    private String name;
    private Supplier<List<Wallet>> wallets;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setWallets(Supplier<List<Wallet>> wallets) {
        this.wallets = wallets;
    }

    public List<Wallet> getWallets() {
        return wallets.get();
    }

    public long getId() {
        return id;
    }
}
