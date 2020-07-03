package pl.coderslab.charity.dto.donation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Getter @Setter @ToString
public class CreateDonationDTO {

    @NotNull
    @Min(1)
    private Integer quantity;

    private List<Category> categories;

    @NotNull
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

    public CreateDonationDTO(@NotNull @Min(1) Integer quantity, List<Category> categories,
                             @NotNull Institution institution, String street,
                             String city, String zipCode,
                             @PastOrPresent LocalDate pickUpDate, @PastOrPresent LocalTime pickUpTime,
                             String pickUpComment) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }
}
