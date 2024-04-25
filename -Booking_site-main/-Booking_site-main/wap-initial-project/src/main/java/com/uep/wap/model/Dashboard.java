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
    private Long dashboardID;
    private Integer totalBookings;
    private BigDecimal totalRevenue;
    private String topDestinations;
    private Double avgRating;
    private String userDemographics;

    @OneToOne
    @JoinColumn(name = "accommodation_id", referencedColumnName = "accommodationID")
    private Accommodation accommodation;

    // Default constructor
    public Dashboard() {
    }


    public Dashboard(Long dashboardID, Integer totalBookings, BigDecimal totalRevenue, String topDestinations, Double avgRating, String userDemographics) {
        this.dashboardID = dashboardID;
        this.totalBookings = totalBookings;
        this.totalRevenue = totalRevenue;
        this.topDestinations = topDestinations;
        this.avgRating = avgRating;
        this.userDemographics = userDemographics;
    }

    public Long getDashboardID() {
        return dashboardID;
    }

    public void setDashboardID(Long dashboardID) {
        this.dashboardID = dashboardID;
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
