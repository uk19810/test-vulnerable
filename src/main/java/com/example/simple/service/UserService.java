package com.example.simple.service;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final DataSource dataSource;

    public UserService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> findEmails(String username) throws SQLException {
        List<String> emails = new ArrayList<>();
        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT email FROM users WHERE username = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            emails.add(rs.getString("email"));
        }
        rs.close();
        stmt.close();
        conn.close();
        return emails;
    }
}
