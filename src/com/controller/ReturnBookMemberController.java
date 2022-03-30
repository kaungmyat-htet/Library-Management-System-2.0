package com.controller;

import com.view.ViewFactory;

public class ReturnBookMemberController extends BaseController{
    private String username;

    public ReturnBookMemberController(ViewFactory viewFactory, String fxmlName, String username) {
        super(viewFactory, fxmlName);
        this.username = username;
    }


}
