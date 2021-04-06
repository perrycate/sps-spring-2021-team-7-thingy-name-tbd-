package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    // switch to true to log data before validating 
    private static final boolean DEBUGGING = true;

    // converts shelters to Json using Gson and returns it as a string
    private String convertSheltersToJson(List<Shelter> shelters) {
        Gson gson = new Gson();
        String json = gson.toJson(shelters);
        return json;
    }

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
            String parameters = "?shelters=";
            List<Shelter> shelters = new ArrayList<Shelter>();
            PopulateShelters.populate(shelters);
            
            String shelterGson = convertSheltersToJson(shelters);
            System.out.println(shelterGson);

            parameters += shelterGson;
            System.out.println(parameters);

            response.sendRedirect("/shelters.html" + parameters);
        }
        else {
            response.sendRedirect("/form.html");
        }
    }
}
