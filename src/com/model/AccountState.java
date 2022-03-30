package com.model;

public interface AccountState {
    AccountState closeAccount();
    AccountState blacklistAccount();
    AccountState cancelAccount();
}
