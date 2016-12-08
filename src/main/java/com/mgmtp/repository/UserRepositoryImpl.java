package com.mgmtp.repository;

import com.mgmtp.model.User;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan Dat on 08/12/2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    private DataSource dataSource;

    @Inject
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM tbl_user;";
        Connection conn = null;
        Statement stmt = null;
        List<User> userList = new ArrayList<>();
        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            User user = null;
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }
}
