package com.belili.pojo;

public class Product  implements java.io.Serializable {

     private Integer idProduct;
     private User user;
     private Warehouse warehouse;
     private String familyProduct;
     private String brandProduct;
     private String modelProduct;
     private String typeProduct;

    public Product() {
    }

    public Product(User user, Warehouse warehouse, String familyProduct, String brandProduct, String modelProduct, String typeProduct) {
       this.user = user;
       this.warehouse = warehouse;
       this.familyProduct = familyProduct;
       this.brandProduct = brandProduct;
       this.modelProduct = modelProduct;
       this.typeProduct = typeProduct;
    }
   
    public Integer getIdProduct() {
        return this.idProduct;
    }
    
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Warehouse getWarehouse() {
        return this.warehouse;
    }
    
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public String getFamilyProduct() {
        return this.familyProduct;
    }
    
    public void setFamilyProduct(String familyProduct) {
        this.familyProduct = familyProduct;
    }
    public String getBrandProduct() {
        return this.brandProduct;
    }
    
    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }
    public String getModelProduct() {
        return this.modelProduct;
    }
    
    public void setModelProduct(String modelProduct) {
        this.modelProduct = modelProduct;
    }
    public String getTypeProduct() {
        return this.typeProduct;
    }
    
    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }




}


