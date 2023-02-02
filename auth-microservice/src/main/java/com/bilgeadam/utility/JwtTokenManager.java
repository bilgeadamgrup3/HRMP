package com.bilgeadam.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    private final String sifreAnahtari = "etbpcQpLkNsUmYCYKwDmp2iwQVxbYAbUKUuK3Tdv7C4KNQtuL9";

    public Optional<String> createToken(Long id){
        String token;

        Long exDate = 1000L*60;
        try{
            token =  JWT.create()
                    .withAudience()
                    .withClaim("id",id) // Token içerisine eklemek istediğiniz nesneleri bununla ekliyoruz.
                    .withClaim("howtopage","AuthMicroService")
                    .withClaim("isOne",true)
                    .withIssuer("java4") // sahibi
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC512(sifreAnahtari));
            return Optional.of(token);
        }catch (Exception ex){
            return Optional.empty();
        }
    }

    public Optional<Long> getByIdFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(sifreAnahtari);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("java4")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT==null)
                return Optional.empty();
            return Optional.of(decodedJWT.getClaim("id").asLong());
        }catch (Exception exception){
            return Optional.empty();
        }

    }
}
