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

public class AddChatRoomServlet extends HttpServlet {
    private Gson gson = new Gson();
    private ListChatRoom listChatRoom = ListChatRoom.getListChatRoom();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream is = req.getInputStream();
             OutputStream os = resp.getOutputStream()) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[10240];
            int len;
            while ((len = is.read(bytes))>0){
                bos.write(bytes,0,len);
            }
            ChatRoom chatRoom = gson.fromJson(bos.toString(),ChatRoom.class);
            if(listChatRoom.getList().contains(chatRoom)){
                os.write("error".getBytes());
            } else {
                listChatRoom.getList().add(chatRoom);
                os.write("ok".getBytes());
            }
        }
    }
}
