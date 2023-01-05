import com.google.gson.Gson;
import controller.UserServiceImpl;
import model.User;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.HashMap;

import static spark.Spark.*;
public class App {
    private static UserServiceImpl userService = new UserServiceImpl();
    public static void main(String[] args) {
        get("/api/users", (req,res) -> users(req,res));
        get("/api/users/:id", (req,res) -> getUser(req,res));
        post("/api/users", (req,res) -> add(req,res));
        put("/api/users/:id", (req,res) -> editUser(req,res));
        options("/api/users/:id", (req,res) -> checkIfUserExists(req,res));
        delete("/api/users/:id", (req,res) -> deleteUser(req,res));
    }

    private static String editUser(Request req, Response res) {
        Gson gson = new Gson();
        String id = req.params("id");
        User newUser = gson.fromJson(req.body(), User.class);
        return userService.editUser(id, newUser).toString();
    }

    private static String deleteUser(Request req, Response res) {
        userService.deleteUser(req.params("id"));
        return "{'status': 'user deleted'}";

    }

    private static String checkIfUserExists(Request req, Response res) {
        return userService.userExist(req.params("id")) ? "{'exists':'true'}" : "{'exists':'false'}";
    }

    private static String getUser(Request req, Response res) {
        String id = req.params("id");
        User user = userService.getUser(id);
        System.out.println(user);
        return user.toString();
    }

    private static String users(Request req, Response res) {
        res.type("application/json");
        HashMap<String, User> users = userService.getUsers();
        System.out.println(users.toString());
        return users.toString();
    }

    static String add(Request req, Response res){
        System.out.println(req.body());
        Gson gson = new Gson();
        User newUser = gson.fromJson(req.body(), User.class);
        System.out.println(newUser);
        userService.addUser(newUser);
        return "{'status': 'user added'}";
    }
}
