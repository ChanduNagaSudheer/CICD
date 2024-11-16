package com.example.CICD.Views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


@Route("")
public class MainView extends VerticalLayout {
    public MainView(){
        TextField email=new TextField("EMAIL");
        TextField git=new TextField("GIT-URL");
        Button btn=new Button("SUBMIT");
        btn.addClickListener(click -> {
            try {
                String scriptPath = "/home/codespace/Scripts_Storage/AutomationController.ctl";

                // Check if the script exists
                File script = new File(scriptPath);
                if (!script.exists() || !script.canExecute()) {
                    throw new FileNotFoundException("Script not found or not executable: " + scriptPath);
                }

                // Execute the script
                ProcessBuilder processBuilder = new ProcessBuilder(scriptPath);
                processBuilder.directory(script.getParentFile()); // Set working directory
                processBuilder.redirectErrorStream(true);

                Process process = processBuilder.start();

                // Read the script output

                // Wait for script execution to complete


            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        add(new VerticalLayout(email,git,btn));
    }
}
