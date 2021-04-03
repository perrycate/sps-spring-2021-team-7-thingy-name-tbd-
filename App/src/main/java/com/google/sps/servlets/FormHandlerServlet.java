package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    // switch to true to log data before validating 
    private static final boolean DEBUGGING = true;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean dataIsValid = true;

        // Get the value entered in the form and checks if non string data are valid
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        Integer age = null;
        Boolean medicalAssistance = null;
        Integer numberOfFamilyMembers = null;
        Boolean disabilities = null;
        Integer days = null; 

        // tries to set the non string variables to user input
        // covers if user mismatches types in their input
        try {
            age = Integer.valueOf(request.getParameter("age"));
            medicalAssistance = Boolean.valueOf(request.getParameter("medicalAssistance"));
            numberOfFamilyMembers = Integer.valueOf(request.getParameter("numberOfFamilyMembers"));
            disabilities = Boolean.valueOf(request.getParameter("disabilities"));
            days = Integer.valueOf(request.getParameter("days"));
        } catch (Exception e) {
            System.out.println("Wrong data format");
            dataIsValid = false;
        }

        User user = new User(name, age, gender, disabilities, medicalAssistance,
                             numberOfFamilyMembers, days);

        // does another check if User input is correct
        if (dataIsValid) {
            if (DEBUGGING) 
                System.out.println(user);
            
            dataIsValid = user.isValid();
        }

        if (dataIsValid) {
            String parameters = "?a=1";
            List<Shelter> shelters = new ArrayList<Shelter>();
            PopulateShelters.populate(shelters);

            response.sendRedirect("/shelters.html" + parameters);
        }
        else {
            response.sendRedirect("/form.html");
        }
    }
}
