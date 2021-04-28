package com.api.product.models.utilities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    // init serialzable id
    private static final long SerialVersionUID = 1L;

    // init property
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // utk auto increment
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "product_name", length = 100) // anotasi column
    private String name;

    @NotEmpty(message = "Description is required")
    @Column(name = "product_descriptions", length = 500) // anotasi column
    private String descriptions;

    private double prices;

    // add relation many to one
    @ManyToOne
    private Category category;

    // add relation many to many
    @ManyToMany
    // create new table to relation many to many
    @JoinTable(name = "tbl_product_supplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> suppliers;

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

    // add setter and getter category
    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.suppliers = supplier;
    }

    public Set<Supplier> getSupplier() {
        return suppliers;
    }
}
