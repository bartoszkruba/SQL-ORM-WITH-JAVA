package models;

import datasource.annotations.Column;
import datasource.annotations.Table;

public class User {

   @Table("users")
   public User() {
   }

   @Column("_id")
   private Long id;

   @Column("first_name")
   private String firstName;

   @Column("last_name")
   private String lastName;

   @Column("email")
   private String email;

   @Column("phone_number")
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
