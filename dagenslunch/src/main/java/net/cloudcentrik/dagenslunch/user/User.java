package net.cloudcentrik.dagenslunch.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    @NotNull
    private String username;

    @Column(name = "user_password")
    @NotNull
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_role")
    private String role;

}
