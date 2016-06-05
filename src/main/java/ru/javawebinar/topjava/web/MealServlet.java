package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;




public class MealServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mealList", UserMealsUtil.getFilteredWithExceededByCycle(UserMealsUtil.mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
              // request.getRequestDispatcher("/mealList.jsp").forward(request, response);
        getServletContext().getRequestDispatcher("/mealList.jsp").forward(request, response);
    }
}