package com.model.AccountStates;

import com.model.AccountState;

public class Active implements AccountState {
    @Override
    public AccountState closeAccount() {
        return new Closed();
        //make changes to the database
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
