import models.*;
import services.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        RoleService roleService = new RoleService();
        User user = new User("Anna", "Marunko", "Sergeevna", "marann", "sudh31");
        userService.saveUser(user);
        user.setGroup(groupService.findGroup(2));
        user.setRole(roleService.findRole(1));
        userService.updateUser(user);
        User user1 = new User("Alexei", "Alexeev", "Alexeevich","alexalex", "sjfh3276");
        userService.saveUser(user1);
        user.setGroup(groupService.findGroup(3));
        user.setRole(roleService.findRole(1));
        userService.updateUser(user1);
        userService.findAllUsers();

    }

}