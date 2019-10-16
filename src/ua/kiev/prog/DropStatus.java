package ua.kiev.prog;

public class DropStatus implements Runnable{
    private static DropStatus dropStatus = new DropStatus();
    private static UserList list = UserList.getInstance();

    private DropStatus() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public static DropStatus getInstance() {
        return dropStatus;
    }


    @Override
    public void run() {
        while (true) {
            list.getUserList().forEach(u -> {
                u.setStatus("Offline");
            });
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
