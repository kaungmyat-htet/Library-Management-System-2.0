package com.model.AccountStates;

import com.model.AccountState;

public class Canceled implements AccountState {
    @Override
    public AccountState closeAccount() {
        return this;
    }

    @Override
    public AccountState blacklistAccount() {
        return this;
    }

    @Override
    public AccountState cancelAccount() {
        return this;
    }
}
