package com.example.azuredemo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="wdb.SalesLT.ProductCategory")
public class ProductCategory {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ProductCategoryID")
    private Integer productCategoryId;

    @Column(name="ParentProductCategoryID")
    private Integer parentProductCategoryID;

    @Column(name="Name")
    private String name;

    private String rowguid;

    @Column(name="ModifiedDate")
    private LocalDateTime modifiedDate;

}
