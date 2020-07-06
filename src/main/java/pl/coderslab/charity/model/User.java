package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @ToString @Table(name = "users")
public class User extends ParentEntity {
    
    @Column(nullable = false, unique = true, length = 60)    
    private String username;
    
    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    public User(){}

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
    }
}
