package com.doorDash.model;

import com.doorDash.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private  USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> favorites = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<RestaurantDto> getFavorites() {
        return favorites;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setFavorites(List<RestaurantDto> favorites) {
        this.favorites = favorites;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
