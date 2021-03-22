package com.example.azuredemo.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Data
@Entity
@Table(name = "wdb.SalesLT.test2")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="create_date")
    private java.util.Date createDate;

    @NotNull
    @Size(min = 5, max = 50, message = "Minium 5 max 50")
    private String name;
}
