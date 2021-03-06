package edu.mum.tm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public boolean isAdmin()
    {
        List<String> roles=this.getRoles().stream().map(x->x.getRole()).collect(Collectors.toList());
        if(roles.contains("ADMIN"))
        {
            return true;
        }
        else
            return false;
    }

    public boolean isFaculty()
    {
        List<String> roles=this.getRoles().stream().map(x->x.getRole()).collect(Collectors.toList());
        if(roles.contains("FACULTY"))
        {
            return true;
        }
        else
            return false;
    }

    public boolean isStudent()
    {
        List<String> roles=this.getRoles().stream().map(x->x.getRole()).collect(Collectors.toList());
        if(roles.contains("STUDENT"))
        {
            return true;
        }
        else
            return false;
    }

    public String getFirstName() {
        return firstName;
    }
}
