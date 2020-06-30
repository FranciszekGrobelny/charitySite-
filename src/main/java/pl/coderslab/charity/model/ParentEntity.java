package pl.coderslab.charity.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter @ToString(of = "id") @EqualsAndHashCode(of = "id")
public class ParentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
