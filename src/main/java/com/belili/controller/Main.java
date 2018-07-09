package com.belili.controller;

import com.belili.model.Model_queries;
import com.belili.model.Model_user;
import com.belili.view.View_createUser;
import com.belili.view.View_login;
import com.belili.view.View_main;

public class Main {

    public static void main(String[] args) {

        Model_user model_user = new Model_user();
        Model_queries model_login = new Model_queries();
        View_login view_login = new View_login();
        View_main view_main = new View_main();
        View_createUser view_createRecorder = new View_createUser();

        Controller_user controller_user = new Controller_user(model_user,
                model_login, view_login, view_main, view_createRecorder);
        controller_user.iniciar();
        view_login.setVisible(true);

    }

}
