package com.sofka.apidemo.model;

import javax.persistence.*;

//Entity: annotation that makes this class to be mapped to a DB
@Entity
//Table: annotation that binds this class to a DB table named "user"
@Table(name = "user")
public class UserModel {

//    Id: annotation for id attribute to be the primary key
    @Id
//    GeneratedValue: annotation that set id attribute as autogenrated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Column: annotation to make id attribute unique within the table
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;
    private Character sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
}
