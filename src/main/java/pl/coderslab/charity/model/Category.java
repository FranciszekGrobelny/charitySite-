package pl.coderslab.charity.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Getter @Setter @ToString @EqualsAndHashCode
public class Category extends ParentEntity{

    private String name;
}
