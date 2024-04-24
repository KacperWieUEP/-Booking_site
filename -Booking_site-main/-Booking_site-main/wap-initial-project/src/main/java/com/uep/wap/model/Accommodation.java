package com.uep.wap.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private BigDecimal pricePerNight;
    private Integer totalRooms;
    private Integer availableRooms;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<Review> reviews;




    // Default constructor
    public Accommodation() {}

    // Constructor with fields
    public Accommodation(String name, String description, String address, String city, String country, Double latitude, Double longitude, BigDecimal pricePerNight, Integer totalRooms, Integer availableRooms) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pricePerNight = pricePerNight;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }

}
