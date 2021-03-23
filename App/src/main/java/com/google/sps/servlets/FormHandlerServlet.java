package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

    private void serverLog(
        String name, String age, String city, String state, Integer numberOfFamilyMemebers
    ) {
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("State " + state);
        System.out.println("# Family members: " + numberOfFamilyMemebers);
        System.out.println("------------------------");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get the value entered in the form.
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        Integer numberOfFamilyMemebers = Integer.valueOf(request.getParameter("numberOfFamilyMemebers"));


        // Print the value so you can see it in the server logs.
        serverLog(name, age, city, state, numberOfFamilyMemebers);

        response.sendRedirect("/form.html");
    }
}