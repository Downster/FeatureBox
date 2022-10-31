package com.example.MessingAround.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name="Users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public String toJSON() throws JsonProcessingException {
        HashMap<String, String> user = new HashMap<>();
        user.put("name", this.getFirstName() + this.getLastName());
        user.put("email", this.getEmail());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(user);
    }
}
