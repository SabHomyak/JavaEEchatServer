package ua.kiev.prog;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SignInAccount extends HttpServlet {
    private Gson gson = new Gson();
    private UserList list = UserList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream is = req.getInputStream();
             OutputStream os = resp.getOutputStream()) {
            ByteArrayOutputStream baous = new ByteArrayOutputStream();
            byte[] bytes = new byte[10240];
            int len = 0;
            while ((len = is.read(bytes)) > 0) {
                baous.write(bytes, 0, len);
            }
            User user = gson.fromJson(baous.toString(), User.class);
            String str;
            if(list.getUserList().contains(user)){
                str = "ok";
            } else {
                str ="error";
            }
            os.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
