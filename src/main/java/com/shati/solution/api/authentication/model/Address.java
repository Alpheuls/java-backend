package com.shati.solution.api.authentication.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence_id")
    @SequenceGenerator(name = "address_sequence_id", sequenceName = "address_sequence_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String streetNumber;
    @Column
    private String Street;
    @Column
    private String district;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String zipCode;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;

    public Address() {
    }

    public Address(Long id, String streetNumber, String street, String district, String city, String state, String country, String zipCode, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.streetNumber = streetNumber;
        Street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
