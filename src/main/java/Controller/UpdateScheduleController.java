package Controller;

import Bean.StudyClass;
import DAO.RegisterDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateScheduleController", value = "/updateclass")
public class UpdateScheduleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String id_str = request.getParameter("scid");
        int id = Integer.parseInt(id_str);

        StudyClassDAO studyClassDAO = new StudyClassDAO();
        StudyClass sc = studyClassDAO.selectClassById(id);
        request.setAttribute("sc",sc);

        request.getRequestDispatcher("/WEB-INF/View/UpdateSchedule.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String tenlop = request.getParameter("tenlop");
        String tenmonhoc = request.getParameter("tenmonhoc");
        String sotin = request.getParameter("sotin");
        String sikip = request.getParameter("sokip");
        String lythuyet = request.getParameter("lythuyet");
        String thuchanh = request.getParameter("thuchanh");
        String thoigian = request.getParameter("thoigian");

        StudyClass studyClass = new StudyClass(Integer.parseInt(id),tenlop,tenmonhoc,Integer.parseInt(sotin),Integer.parseInt(sikip),Integer.parseInt(lythuyet),Integer.parseInt(thuchanh),thoigian);
        StudyClassDAO studyClassDAO = new StudyClassDAO();
        try {
            boolean check = studyClassDAO.updateClass(studyClass);

            if(check){
                request.setAttribute("update_sucess","Cập nhật thành công!");
                request.getRequestDispatcher("/WEB-INF/View/UpdateSchedule.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
