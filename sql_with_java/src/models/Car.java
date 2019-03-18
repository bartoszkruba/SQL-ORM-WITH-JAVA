package models;


import datasource.annotations.Column;
import datasource.annotations.Table;

import java.sql.Timestamp;

public class Car {

   @Column("_id")
   private Long id;

   @Column("plate_number")
   private String plateNumber;

   @Column("model")
   private String model;

   @Column("color")
   private String color;

   @Column("owner_id")
   private Long ownerId;

   @Column("desciption")
   private String description;

   @Column("total_distance")
   private Long total_distance;

   @Column("production_year")
   private Timestamp productionYear;

   @Table("cars")
   public Car() {
   }

   public Long getId() {
      return id;
   }

   public Long getTotal_distance() {
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

   public Long getOwnerId() {
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

   public Car setOwnerId(Long ownerId) {
      this.ownerId = ownerId;
      return this;
   }

   public Car setDescription(String description) {
      this.description = description;
      return this;
   }

   public Car setTotal_distance(Long total_distance) {
      this.total_distance = total_distance;
      return this;
   }

   public Car setProductionYear(Timestamp productionYear) {
      this.productionYear = productionYear;
      return this;
   }
}
