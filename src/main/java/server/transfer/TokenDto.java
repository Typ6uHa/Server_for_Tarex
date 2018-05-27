package server.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import server.model.Token;
import server.model.TokenRestaurant;

@Data
@AllArgsConstructor
public class TokenDto {
    private String value;

    public static TokenDto from(Token token){
        return new TokenDto(token.getValue());
    }
    public static TokenDto from(TokenRestaurant tokenRestaurant){
        return new TokenDto(tokenRestaurant.getValue());
    }
}
