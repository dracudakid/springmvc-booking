package com.mgmtp.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Tan Dat on 07/12/2016.
 */
public class User {
     @NotNull
     private int id;
     @NotNull
     @Size(min = 6, max = 255)
     private String username;
     @NotNull
     @Size(min = 6, max = 255)
     private String password;
     @NotBlank
     private String fullname;
     @Past
     private Date dob;
     private String email;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getFullname() {
          return fullname;
     }

     public void setFullname(String fullname) {
          this.fullname = fullname;
     }

     public Date getDob() {
          return dob;
     }

     public void setDob(Date dob) {
          this.dob = dob;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }
}
