package pl.coderslab.charity.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = false)
public class Donation extends ParentEntity {

    private Integer quantity;

    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

}

//    id
//    quantity (liczba worków) (Integer)
//        categories (lista obiektów typu Category), pamiętaj o odpowiedniej adnotacji
//        institution (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.
//        street (String)
//        city (String)
//        zipCode (String)
//        pickUpDate (LocalDate)
//        pickUpTime (LocalTime)
//        pickUpComment (String)
