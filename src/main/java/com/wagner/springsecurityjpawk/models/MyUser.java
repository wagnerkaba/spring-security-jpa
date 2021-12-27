package com.wagner.springsecurityjpawk.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "myuser")
// ========================================================
// ATENÇÃO: eu havia colocado @Table(name = "user") e deu erro: PSQLException: ERROR: syntax error at or near "user"
// De acordo com o StackOverflow:
// The word user is a reserved word in Postgres.
// User is actually a reserved keyword that Spring JPA doesn't "escape" as-is.
// However, you can do the keyword escape like so in your entity declaration: @Table(name = "\"User\"")
// Fonte: https://stackoverflow.com/questions/50211694/postgres-ddl-error-syntax-error-at-or-near-user
// ========================================================
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;
    private String username;
    private String password;
    private boolean active;
    private String roles;

}
