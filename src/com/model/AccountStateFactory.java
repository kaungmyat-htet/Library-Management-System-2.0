package com.model;

import com.model.AccountStates.Active;
import com.model.AccountStates.Blacklisted;
import com.model.AccountStates.Canceled;
import com.model.AccountStates.Closed;
import com.util.InvalidAccountStatus;

public class AccountStateFactory {
    public static AccountState build(AccountStatus status) throws Exception {
        switch (status) {
            case ACTIVE -> {
                return new Active();
            }
            case CLOSED -> {
                return new Closed();
            }
            case CANCELLED -> {
                return new Canceled();
            }
            case BLACKLISTED -> {
                return new Blacklisted();
            }
            default -> throw new InvalidAccountStatus("Invalid Account Status");
        }
    }
}
