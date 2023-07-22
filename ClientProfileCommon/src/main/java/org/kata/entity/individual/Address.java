package org.kata.entity.individual;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    @Column(name = "address_name")
    private String addressName;
    private String country;
    private String zipCode;
    private String province;
    @Column(name = "province_type")
    private String provinceType;
    private String region;
    @Column(name = "region_type")
    private String regionType;
    private String city;
    @Column(name = "city_type")
    private String cityType;
    private String settlement;
    @Column(name = "settlement_type")
    private String settlementType;
    private String street;
    @Column(name = "street_type")
    private String streetType;
    @Column(name = "addition_area_street")
    private String additionAreaStreet;
    private String house;
    private String housing;
    private String building;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id", referencedColumnName = "id")
    private Individual individual;
}
