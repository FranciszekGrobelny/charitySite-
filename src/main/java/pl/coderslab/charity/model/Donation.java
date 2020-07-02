package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter @Setter @ToString(exclude = {"categories","institution"})
public class Donation extends ParentEntity {

    @Column(nullable = false)
    @NotNull @Min(1)
    private Integer quantity;

    @ManyToMany @NotNull
    private List<Category> categories;

    @ManyToOne @NotNull
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @PastOrPresent
    private LocalTime pickUpTime;

    private String pickUpComment;

}

