package Dynamicloading;

public class Client {
    public static void main(String[] args) {
        try {
            Class office = Class.forName("Dynamicloading.Excel");
            Office office1 = (Office) office.newInstance();
            office1.start();
            //Office excel =(Office) office.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
