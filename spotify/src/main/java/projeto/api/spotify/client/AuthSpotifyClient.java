package projeto.api.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projeto.api.spotify.dto.LoginRequest;
import projeto.api.spotify.dto.LoginResponse;

@FeignClient(
        name = "AuthSpotify",
        url = "https://accounts.spotify.com"
)
public interface AuthSpotifyClient {

    @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    LoginResponse login(@RequestBody LoginRequest loginRequest);

}
