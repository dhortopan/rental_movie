package application.rental_movie.entities_models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "expired")
    private boolean expired;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "credentials")
    private boolean credentials;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRoles;


    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Rental> rentals;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userRoles
                .stream()
                .map(e -> new SimpleGrantedAuthority(e.getUserType().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentials;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
