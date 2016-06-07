package ru.javawebinar.topjava.web;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.repository.MealRepositoryImplementation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MealServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);
   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

// adding LocalDateTime
        LocalDateTime dateNow = LocalDateTime.now();
        String localDateTimeParameters = dateNow.format(formatter).replace('T',' ');
        LocalDateTime parsedDate = LocalDateTime.parse(localDateTimeParameters, formatter);

//adding another parameters
        String descriptionParamValue = request.getParameter("description");
        String caloriesParamValue = request.getParameter("calories");
        String idParamValue = request.getParameter("id");
        if (!localDateTimeParameters.equals("") && descriptionParamValue != null && caloriesParamValue != null) {
            if (caloriesParamValue.matches("^\\d+$")) {
                LOG.debug("add new UserMeal");
                MealRepositoryImplementation repository = MealRepositoryImplementation.getInstance();
                            UserMeal newMeal = new UserMeal(parsedDate,
                        descriptionParamValue, Integer.valueOf(caloriesParamValue));
                if (idParamValue.matches("^\\d+$")) repository.edit(Integer.valueOf(idParamValue), newMeal);
                else repository.add(newMeal);
                     }
        }
        showMainPage(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealRepositoryImplementation repository = MealRepositoryImplementation.getInstance();

        String doParamValue = request.getParameter("do");
        String idParamValue = request.getParameter("id");
        if (doParamValue != null) {
            if (idParamValue != null && idParamValue.matches("^\\d+$")) {
                if (doParamValue.equals("delete")) {
                    LOG.debug("remove UserMeal with id: " + idParamValue);
                    repository.remove(Integer.parseInt(idParamValue));
                }else if (doParamValue.equals("edit")) {
                    LOG.debug("show edit page UserMeal with id: " + idParamValue);
                    UserMeal um = repository.getById(Integer.valueOf(idParamValue));
                //    request.setAttribute("dateTime", um.getDateTime());
                    request.setAttribute("description", um.getDescription());
                    request.setAttribute("calories", um.getCalories());
                    request.setAttribute("id", um.getId());
                }
            }
        }

        showMainPage(request, response);
    }

    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("get mealList");
        MealRepositoryImplementation repository = MealRepositoryImplementation.getInstance();
        List<UserMealWithExceed> list = repository.listWithExceed();
        request.setAttribute("formatter",formatter);
        request.setAttribute("meals", list);

        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
    }
}