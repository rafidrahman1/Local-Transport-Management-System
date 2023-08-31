package com.ltms.ltms.Authentication;
import java.sql.*;
import com.ltms.ltms.entity.UserEntity;
import com.ltms.ltms.models.UserModel;
import com.ltms.ltms.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserLogin {

    private final UserService userService;

    public UserLogin(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserCredentials credentials) throws SQLException {
        String id = credentials.getId();
        String password = credentials.getPassword();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltms_db", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `user-entity` WHERE id = '" + id + "'");
        resultSet.next();
            if (resultSet.getString("id").equals(id) && resultSet.getString("password").equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
            }

    }
    @PostMapping("/process-input")
    public ResponseEntity<String> processInput(@RequestBody InputCredentials inputData) throws SQLException {
        String userInput = inputData.getId();
        String MyId = inputData.getMyId();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltms_db", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `category` WHERE name = '" + userInput + "'");
        resultSet.next();
        if (resultSet.getString("name").equals(userInput) && resultSet.getInt("category_id")!=0) {
            double i = resultSet.getDouble("category_id");
            String balanceUpdate = "UPDATE `user-entity` SET balance = balance+"+i+" WHERE id = " + MyId + " ";
            PreparedStatement balanceInfo = connection.prepareStatement(balanceUpdate);
            balanceInfo.executeUpdate();
            String zeroUpdate = ("UPDATE `category` SET category_id = category_id-"+i+" WHERE name = '" + userInput + "'");
            PreparedStatement zeroInfo = connection.prepareStatement(zeroUpdate);
            zeroInfo.executeUpdate();
            return ResponseEntity.ok("Recharged");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Input not found in the table");
        }
    }


    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserModel userModel) {
        UserEntity userEntity = userService.createUser(userModel);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
