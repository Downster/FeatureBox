package com.example.MessingAround.model.response;
import java.io.Serializable;


public record JwtResponse(String jwttoken) implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
}
