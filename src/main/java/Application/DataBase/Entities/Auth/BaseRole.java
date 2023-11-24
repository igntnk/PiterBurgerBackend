package Application.DataBase.Entities.Auth;

public enum BaseRole {
    CUSTOMER("ROLE_SUPER_USER", "SUPER_USER"),
    WORKER("ROLE_MANAGER", "MANAGER"),
    MANAGER("ROLE_WORKER", "WORKER"),
    SUPER_USER("ROLE_CUSTOMER", "CUSTOMER");

    private final String value;
    private final String role;

    BaseRole(String value, String role){
        this.value = value;
        this.role = role;
    }

}
