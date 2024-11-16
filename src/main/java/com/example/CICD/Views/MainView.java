package com.example.CICD.Views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.IOException;


@Route("")
public class MainView extends VerticalLayout {
    public MainView(){
        TextField email=new TextField("EMAIL");
        TextField git=new TextField("GIT-URL");
        Button btn=new Button();
        btn.addClickListener(click -> {
            try {
            ProcessBuilder processBuilder = new ProcessBuilder("/home/codespace/Scripts_Storage/AutomationController.ctl");
            processBuilder.directory(new java.io.File(System.getProperty("/home/codespace/Scripts_Storage"))); // Set working directory

            // Start the process

                Process process = processBuilder.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        add(new VerticalLayout(email,git,btn));
    }
}
