import models.*;
import services.AutoService;
import services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws SQLException {
        String[] names = {"ELena", "Tom", "Max", "Katya", "Sergey", "Anna", "Alex", "Nikita", "Masha", "Ivan"};
        Integer[] ages = {20, 25, 30, 35, 40, 45, 50, 55, 60, 23, 28, 32, 36, 39, 44, 48, 49, 54, 57, 62};
        String[] models = {"BMW", "Mercedes", "Lada", "Ford", "Audi", "Volvo", "Volkswagen", "Renault"};
        String[] colors = {"red", "black", "white", "grey", "blue", "yellow", "green", "cyan"};
        UserService userService = new UserService();
        AutoService autoService = new AutoService();
        for (int i=0; i < 10; i++){
            User user = new User(names[getRandom(names)], ages[getRandom(ages)]);
            userService.saveUser(user);
            Auto auto = new Auto(models[getRandom(models)], colors[getRandom(colors)]);
            autoService.saveAuto(auto);
            user.addAuto(auto);
            userService.updateUser(user);
        }
        List<User> userList = userService.findAllUsers();
        for (User userFor:userList) {
            System.out.println(userFor);
        }

        List<Auto> autoList = autoService.findAllAutos();
        for (Auto autoFor:autoList) {
            System.out.println(autoFor);
        }

        System.out.println(userService.findUser(5));
        System.out.println(userService.findByAutoId(7));
        System.out.println(autoService.findAuto(3));

        for (int i=0; i < 10; i++){
            User user = userService.findUser(i+1);
            userService.deleteUser(user);
        }


    }

    public static <T> int getRandom(T[] array){
        Random r=new Random();
        return r.nextInt(array.length);
    }

}
