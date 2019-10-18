package ua.kiev.prog;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class ListChatRoom {
    private static ListChatRoom listChatRoom = new ListChatRoom();
    private List<ChatRoom> list = new LinkedList<>();

    private ListChatRoom() {
        list.add(new ChatRoom("room", "1234"));
    }

    public static ListChatRoom getInstance() {
        return listChatRoom;
    }

    public static ListChatRoom getListChatRoom() {
        return listChatRoom;
    }

    public static void setListChatRoom(ListChatRoom listChatRoom) {
        ListChatRoom.listChatRoom = listChatRoom;
    }

    public List<ChatRoom> getList() {
        return list;
    }

    public void setList(List<ChatRoom> list) {
        this.list = list;
    }
}
