package models;

import datasource.annotations.Column;
import datasource.annotations.KeyDescription;
import datasource.annotations.Table;


import datasource.annotations.Column;
import datasource.annotations.KeyDescription;
import datasource.annotations.Table;

import java.sql.Timestamp;

public class Car {

   @Table("cars")
   public Car() {
   }

   @Column("_id")
   @KeyDescription("INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY")
   private Long id;

   @Column("plate_number")
   @KeyDescription("VARCHAR(20) NOT NULL")
   private String plateNumber;

   @Column("model")
   @KeyDescription("VARCHAR(50) NOT NULL")
   private String model;

   @Column("color")
   @KeyDescription("VARCHAR(50)")
   private String color;

   @Column("owner_id")
   @KeyDescription("INT(10) UNSIGNED NOT NULL, " +
           "FOREIGN KEY (owner_id) REFERENCES users(_id) " +
           "ON UPDATE CASCADE ON DELETE CASCADE")
   private Long ownerId;

   @Column("desciption")
   @KeyDescription("VARCHAR(250)")
   private String description;

   @Column("total_distance")
   @KeyDescription("INT(10) UNSIGNED NOT NULL")
   private Long total_distance;

   @Column("production_year")
   @KeyDescription("TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
   private Timestamp productionYear;


   public long getId() {
      return id;
   }

   public long getTotal_distance() {
      return total_distance;
   }

   public String getPlateNumber() {
      return plateNumber;
   }

   public String getModel() {
      return model;
   }

   public String getColor() {
      return color;
   }

   public long getOwnerId() {
      return ownerId;
   }

   public String getDescription() {
      return description;
   }

   public Timestamp getProductionYear() {
      return productionYear;
   }

   public Car setId(Long id) {
      this.id = id;
      return this;
   }

   public Car setPlateNumber(String plateNumber) {
      this.plateNumber = plateNumber;
      return this;
   }

   public Car setModel(String model) {
      this.model = model;
      return this;
   }

   public Car setColor(String color) {
      this.color = color;
      return this;
   }

   public Car setOwnerId(long ownerId) {
      this.ownerId = ownerId;
      return this;
   }

   public Car setDescription(String description) {
      this.description = description;
      return this;
   }

   public Car setTotal_distance(long total_distance) {
      this.total_distance = total_distance;
      return this;
   }

   public Car setProductionYear(Timestamp productionYear) {
      this.productionYear = productionYear;
      return this;
   }
}
