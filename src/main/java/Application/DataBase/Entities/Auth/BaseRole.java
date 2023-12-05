package Application.DataBase.Entities.Auth;

import lombok.Getter;

@Getter
public enum BaseRole {
    CUSTOMER("ROLE_CUSTOMER", "CUSTOMER"),
    WORKER("ROLE_WORKER", "WORKER"),
    MANAGER("ROLE_MANAGER", "MANAGER"),
    SUPER_USER("ROLE_SUPER_USER", "SUPER_USER");

    private final String value;
    private final String role;

    BaseRole(String value, String role){
        this.value = value;
        this.role = role;
    }



}
