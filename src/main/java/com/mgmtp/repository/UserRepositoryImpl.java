package com.mgmtp.repository;

import com.mgmtp.model.User;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
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

    @Override
    public void save(User user) {
        String sql = " INSERT INTO tbl_user(username, password, fullname, dob, email) values(?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3,user.getFullname());
            stmt.setDate(4, new Date(user.getDob().getTime()));
            stmt.setString(5, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (stmt != null){
                    stmt.close();
                }
                if( conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
