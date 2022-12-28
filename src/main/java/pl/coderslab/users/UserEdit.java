package pl.coderslab.users;

import pl.coderslab.User;
import pl.coderslab.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        User user = new User();
        UserDao userDao = new UserDao();
        user = userDao.read(id);
        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);

        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("userEmail"));
        user.setPassword(req.getParameter("userPassword"));
        user.setId(id);

        UserDao userDao = new UserDao();
        userDao.update(user);

        resp.sendRedirect(req.getContextPath()+"list");
    }
}
