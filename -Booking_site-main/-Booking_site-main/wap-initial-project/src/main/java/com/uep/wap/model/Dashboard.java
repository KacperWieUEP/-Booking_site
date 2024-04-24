package com.uep.wap.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;;

@Entity
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalBookings;
    private BigDecimal totalRevenue;
    private String topDestinations;
    private Double avgRating;
    private String userDemographics;

    // Default constructor
    public Dashboard() {}

    // Constructor with fields
    public Dashboard(Integer totalBookings, BigDecimal totalRevenue, String topDestinations, Double avgRating, String userDemographics) {
        this.totalBookings = totalBookings;
        this.totalRevenue = totalRevenue;
        this.topDestinations = topDestinations;
        this.avgRating = avgRating;
        this.userDemographics = userDemographics;
    }



    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Accommodation> accommodations;

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Review> reviews;



    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(Integer totalBookings) {
        this.totalBookings = totalBookings;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getTopDestinations() {
        return topDestinations;
    }

    public void setTopDestinations(String topDestinations) {
        this.topDestinations = topDestinations;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public String getUserDemographics() {
        return userDemographics;
    }

    public void setUserDemographics(String userDemographics) {
        this.userDemographics = userDemographics;
    }
}
