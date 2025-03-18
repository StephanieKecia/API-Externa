package projeto.api.spotify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {

    @JsonProperty("access_token")
    private String accessToken;

}
