package com.kata.clientprofilefacade.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ip_ranges")
@Data
public class IPRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_ip")
    private String startIp;
    @Column(name = "end_ip")
    private String endIp;
    @Column(name = "city")
    private String city;
}
