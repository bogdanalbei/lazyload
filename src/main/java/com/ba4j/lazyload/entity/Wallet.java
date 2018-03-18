package com.ba4j.lazyload.entity;

public class Wallet {
    private long id;
    private String address;
    private long userId;

    public Wallet(long id, String address, long userId) {
        this.id = id;
        this.address = address;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
