package models;

import datasource.annotations.Column;
import datasource.annotations.KeyDescription;
import datasource.annotations.Table;

public class User {

   @Table("users")
   public User() {
   }

   @Column("_id")
   @KeyDescription("INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY")
   private Long id;

   @Column("first_name")
   @KeyDescription("VARCHAR(250) NOT NULL")
   private String firstName;

   @Column("last_name")
   @KeyDescription("VARCHAR(250) NOT NULL")
   private String lastName;

   @Column("email")
   @KeyDescription("VARCHAR(250) NOT NULL")
   private String email;

   @Column("phone_number")
   @KeyDescription("VARCHAR(20) NOT NULL")
   private String phoneNumber;

   public long getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getEmail() {
      return email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public User setId(long id) {
      this.id = id;
      return this;
   }

   public User setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
   }

   public User setLastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   public User setEmail(String email) {
      this.email = email;
      return this;
   }

   public User setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
   }
}
