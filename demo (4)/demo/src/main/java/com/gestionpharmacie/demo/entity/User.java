package com.gestionpharmacie.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import  com.gestionpharmacie.demo.enums.userRole;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User implements UserDetails {


        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private  Long id;

        private String name;

        private String email;

        @Getter
        private String password;
        @Getter
        private  userRole  userRole;
        public User() {

        }
   // @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "cart_id", referencedColumnName = "id")
   // private Cart cart;

   // public Cart getCart() {
     //   return cart;
    //}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));

    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserRole(userRole userRole) {
        this.userRole = userRole;
    }
}
