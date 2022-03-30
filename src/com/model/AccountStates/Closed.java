package com.model.AccountStates;

import com.model.AccountState;

public class Closed implements AccountState {

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
