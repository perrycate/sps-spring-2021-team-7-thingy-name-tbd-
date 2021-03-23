package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    // switch to true to log data before validating 
    private static final boolean DEBUGGING = false;

    private void serverLog(
        String name, String age, String city, String state, String numberOfFamilyMemebers
    ) {
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("State " + state);
        System.out.println("# Family members: " + numberOfFamilyMemebers);
        System.out.println("------------------------");
    }

    private void checkIfValid(
        String name, String age, String city, String state, String numberOfFamilyMemebers
    ) {
        if (name == null || name.length() < 2) {
            System.out.println("Name is too short");
        }
        if (age == null || age.length() > 3) {
            System.out.println("Age out of range");
        }
        if (city == null || city.length() < 2) {
            System.out.print("City name too small");
        }
        if (numberOfFamilyMemebers == null || numberOfFamilyMemebers.length() < 1) {
            System.out.println("Family is too small");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get the value entered in the form.
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String numberOfFamilyMemebers = request.getParameter("numberOfFamilyMemebers");


        if (DEBUGGING) 
            serverLog(name, age, city, state, numberOfFamilyMemebers);
        
        checkIfValid(name, age, city, state, numberOfFamilyMemebers);

        response.sendRedirect("/shelters.html");
    }
}