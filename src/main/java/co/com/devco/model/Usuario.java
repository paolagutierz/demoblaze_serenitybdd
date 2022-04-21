package co.com.devco.model;

public class Usuario {
    private String username;
    private String password;
    private String rol;

    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void setUsPw(){
        if ("admin".equals(this.rol)){
            this.username = "admin";
            this.password = "admin";
        } else{
            this.username = "dummy";
            this.password = "dummy";
        }
    }
}
