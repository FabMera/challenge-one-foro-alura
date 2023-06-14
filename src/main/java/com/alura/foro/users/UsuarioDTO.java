package com.alura.foro.users;

public class UsuarioDTO {
    private String login;
    private String clave;

    public UsuarioDTO(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    public UsuarioDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
