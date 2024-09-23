package co.com.pragma.utils.authorization;

import co.com.pragma.domain.model.CustomException;
import co.com.pragma.domain.model.ResponseCode;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class AuthorizationToken {
    AuthorizationToken(){
        throw new CustomException(ResponseCode.LCC004, ResponseCode.LCC004.getHtmlMessage());
    }

    public static String getEmail(String idToken) {
        if (idToken == null || idToken.isEmpty()) {
            throw new CustomException(ResponseCode.LCC003, ResponseCode.LCC003.getHtmlMessage());
        }

        DecodedJWT decodedJwt = JWT.decode(idToken);
        String email = decodedJwt.getClaim("email").asString();

        if (email == null){
            throw new CustomException(ResponseCode.LCC001, ResponseCode.LCC001.getHtmlMessage());
        }

        return email;
    }

    public static String getIdUser(String idToken){
        if (idToken == null || idToken.isEmpty()) {
            throw new CustomException(ResponseCode.LCC001, ResponseCode.LCC001.getHtmlMessage());
        }

        String idUser;

        try{
            DecodedJWT decodedJwt = JWT.decode(idToken);
            idUser = decodedJwt.getClaim("custom:userid").asString();
        }catch (Exception e){
            throw new CustomException(ResponseCode.LCC003, ResponseCode.LCC003.getHtmlMessage());
        }

        return idUser;
    }
}