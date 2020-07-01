package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter @Setter @ToString(exclude = {"categories","institution"})
public class Donation extends ParentEntity {

    private Integer quantity;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

}

