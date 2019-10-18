package ua.kiev.prog;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetChatUserServlet extends HttpServlet {
    private ListChatRoom list = ListChatRoom.getInstance();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do");
        try(PrintWriter pw = resp.getWriter()){
            pw.println(gson.toJson(list.getList()));
        }
    }
}
