package View;


import Service.Alarmsystem;


public class Main {
    public static void main(String[] args) {


        Alarmsystem system = new Alarmsystem();
        Menu menu = new Menu(system);
        menu.run();


    }
}















