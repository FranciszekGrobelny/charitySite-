package pl.coderslab.charity.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "institutions")
@Getter @Setter @ToString
public class Institution extends ParentEntity {

    @NotNull
    private String name;

    private String description;
}
