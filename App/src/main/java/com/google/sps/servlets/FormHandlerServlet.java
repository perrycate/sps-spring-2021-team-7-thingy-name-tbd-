package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    // switch to true to log data before validating 
    private static final boolean DEBUGGING = true;

    private void serverLog(
        String name, String gender, Integer age, Boolean medicalAssistance, Integer numberOfFamilyMembers, 
        Boolean disabilities
    ) {
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("# Family members: " + numberOfFamilyMembers);
        System.out.println("Disabilities: " + disabilities);
        System.out.println("Medical Assistance: " + medicalAssistance);
        System.out.println("------------------------");
    }

    private boolean checkIfValid(
        String name, String gender, Integer age, Boolean medicalAssistance, Integer numberOfFamilyMembers, 
        Boolean disabilities
    ) {
        if (name == null || name.length() < 2) {
            System.out.println("Name is too short");
            return false;
        }
        if (gender == null) {
            System.out.println("Gender not selected");
            return false;
        }
        if (age == null || age < 1 || age > 150) {
            System.out.println("Age is out of range");
            return false;
        }
        if (medicalAssistance == null) {
            System.out.println("Medical Assistance not selected");
            return false;
        }
        if (numberOfFamilyMembers == null || numberOfFamilyMembers > 25 || 
            numberOfFamilyMembers < 0) {
            System.out.println("NFM is out of range");  
            return false;
        } 
        if (disabilities == null) {
            System.out.println("Disabilities not selected");
            return false;
        }

        return true;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean dataIsValid = true;

        // Get the value entered in the form and checks if non string data are valid
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Boolean medicalAssistance = Boolean.valueOf(request.getParameter("medicalAssistance"));
        Integer numberOfFamilyMembers = Integer.valueOf(request.getParameter("numberOfFamilyMembers"));
        Boolean disabilities = Boolean.valueOf(request.getParameter("disabilities"));

        if (DEBUGGING) 
            serverLog(name, gender, age, medicalAssistance, numberOfFamilyMembers, disabilities);
        
        dataIsValid = checkIfValid(name, gender, age, medicalAssistance, 
            numberOfFamilyMembers, disabilities);

        // this is where the User object would be instantiated and the String types converted

        if (dataIsValid)
            response.sendRedirect("/shelters.html");
        else
            response.sendRedirect("/form.html");
    }
}