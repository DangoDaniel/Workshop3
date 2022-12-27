package pl.coderslab.users;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.read(id);

        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("buttonList");
        if ("showList".equals(value)){
            resp.sendRedirect(req.getContextPath()+ "list");
        }
        }
    }
