package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Getter @Setter @ToString @Table(name = "users")
public class User extends ParentEntity {

    private String email;

    private String password;

}
