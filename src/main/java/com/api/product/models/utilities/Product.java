package com.api.product.models.utilities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.SerialVersionUID;

@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    // init serialzable id
    private static final long SerialVersionUID = 1L;

    // init property
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // utk auto increment
    private Long id;

    @Column(name = "product_name", length = 100) // anotasi column
    private String name;

    @Column(name = "product_descriptions", length = 500) // anotasi column
    private String descriptions;

    private double prices;

    // build constructor
    public Product() {

    }

    public Product(Long id, String name, String descriptions, double prices) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.prices = prices;
    }

    // setter and getter
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getPrice() {
        return this.prices;
    }

    public void setPrice(double prices) {
        this.prices = prices;
    }
}
