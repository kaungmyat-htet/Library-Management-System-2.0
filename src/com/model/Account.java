package com.model;

import com.model.AccountStates.Active;
import com.model.AccountStates.Blacklisted;
import com.model.AccountStates.Canceled;
import com.model.AccountStates.Closed;
import com.persistence.SqlUserRepo;
import com.persistence.UserRepo;

import java.util.Optional;

public class Account {
    private String username;
    private String password;
    private AccountStatus status;
    private AccountState state;

    public Account(String username, String password, AccountStatus status) throws Exception {
        this.username = username;
        this.password = password;
        this.status = status;
        setAccountState(status);
    }

    public Account(String username, AccountStatus status) throws Exception {
        this.username = username;
        this.status = status;
        setAccountState(status);
    }

    private void setAccountState(AccountStatus status) throws Exception {
        this.state = AccountStateFactory.build(status);
    }

    public Account(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public AccountState getState() {
        return state;
    }

    public Optional<User> viewProfile() throws Exception {
        UserRepo repo = new SqlUserRepo();
        Optional<User> user = repo.getByUsername(this.getUsername());
        if (user.isEmpty()) {
            System.out.println("Invalid User : User not found in the database!");
        }
        return user;
    }

    public void closeAccount() {
        this.state = this.state.closeAccount();
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", state=" + state +
                '}';
    }
}
