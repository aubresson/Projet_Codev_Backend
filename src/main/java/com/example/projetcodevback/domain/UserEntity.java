package com.example.projetcodevback.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "codev", catalog = "")
public class UserEntity {
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Collection<UserCarEntity> userCarsById;
    private Collection<UserCarEntity> userCarsById_0;
    private Collection<UserCarEntity> userCarsById_1;
    private Collection<UserPlaceEntity> userPlacesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserCarEntity> getUserCarsById() {
        return userCarsById;
    }

    public void setUserCarsById(Collection<UserCarEntity> userCarsById) {
        this.userCarsById = userCarsById;
    }

    @OneToMany(mappedBy = "userByUserId_0")
    public Collection<UserCarEntity> getUserCarsById_0() {
        return userCarsById_0;
    }

    public void setUserCarsById_0(Collection<UserCarEntity> userCarsById_0) {
        this.userCarsById_0 = userCarsById_0;
    }

    @OneToMany(mappedBy = "userByUserId_1")
    public Collection<UserCarEntity> getUserCarsById_1() {
        return userCarsById_1;
    }

    public void setUserCarsById_1(Collection<UserCarEntity> userCarsById_1) {
        this.userCarsById_1 = userCarsById_1;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserPlaceEntity> getUserPlacesById() {
        return userPlacesById;
    }

    public void setUserPlacesById(Collection<UserPlaceEntity> userPlacesById) {
        this.userPlacesById = userPlacesById;
    }
}
