package pl.wsei.storespring.dto;

import jakarta.validation.constraints.*;
import pl.wsei.storespring.model.Basket;
import pl.wsei.storespring.model.User;

public class UserDTO {

    public long id;
    @NotBlank
    public String name;
    @Size(min = 2)
    public String surname;
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    public String login;
    @Email
    public String email;

    public Basket basket;


    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.name = user.getName();
        userDTO.surname = user.getSurname();
        userDTO.login = user.getLogin();
        userDTO.email = user.getEmail();
        userDTO.basket = user.getBasket();
        return userDTO;
    }

    public static User toEntity(UserDTO userDto) {
        User user = new User();
        user.setId(userDto.id);
        user.setName(userDto.name);
        user.setSurname(userDto.surname);
        user.setLogin(userDto.login);
        user.setEmail(userDto.email);
        user.setBasket(userDto.basket);
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
