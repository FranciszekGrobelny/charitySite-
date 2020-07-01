package pl.coderslab.charity.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "institutions")
@Getter @Setter @ToString
public class Institution extends ParentEntity {

    private String name;

    private String description;
}
