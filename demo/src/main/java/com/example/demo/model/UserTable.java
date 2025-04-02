package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name="user_table")
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    private char[] passwd;

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPasswd() {
        return passwd;
    }

    public void setPasswd(char[] passwd) {
        this.passwd = passwd;
    }
}
