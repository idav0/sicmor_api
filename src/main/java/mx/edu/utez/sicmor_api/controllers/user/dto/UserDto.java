package mx.edu.utez.sicmor_api.controllers.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicmor_api.models.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;

    private String name;

    private String password;

    public User getUser() {
        return new User(
                getId(),
                getName(),
                getPassword()
        );
    }

}
