package DataBase.Entities.Auth;

public enum BaseRole {
    USER("ROLE_USER","USER"),
    WORKER("ROLE_WORKER","WORKER"),
    MANAGER("ROLE_MANAGER","MANAGER"),
    SUPER_USER("ROLE_SUPER_USER","SUPER_USER");

    private final String value;
    private final String role;

    BaseRole(String value, String role){
        this.value = value;
        this.role = role;
    }
}
