package com.scorecard.scoreboard.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scorecard.scoreboard.Api.SignUpRequest;
import com.scorecard.scoreboard.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String username;
    @NaturalId(mutable = true)
    private String email;
    private String password;
    private String squad;
    private String stack;
    private Character pod;
    private Role role;
    private Boolean locked = false;
    private Boolean isEnabled = false;


    public User(SignUpRequest signUpRequest) {
        this.firstName = signUpRequest.getFirstName();
        this.lastName = signUpRequest.getLastName();
        this.username = signUpRequest.getUserName();
        this.email = signUpRequest.getEmail();
        this.password = signUpRequest.getPassword();
        this.squad = signUpRequest.getSquad();
        this.stack = signUpRequest.getStack();
        this.pod = signUpRequest.getPod();
        this.role = signUpRequest.getRoles();
    }




    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(this.role.name()));
        return grantedAuthorityList;
    }


    @Override
    public String getUsername() {
        return username ;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    }




