package projeto.api.spotify.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.api.spotify.dto.Album;
import projeto.api.spotify.client.AlbumSpotifyClient;
import projeto.api.spotify.client.AuthSpotifyClient;
import projeto.api.spotify.dto.LoginRequest;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@AllArgsConstructor
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;


    @GetMapping("/albums")
    public ResponseEntity<List<Album>> helloWorld(){

        var request = new LoginRequest(
                "client_credentials",
                "SUA-CREDENCIAL",
                "CREDENCIAL-SECRETA"
        );

        var token = authSpotifyClient.login(request).getAccessToken();

        var release = albumSpotifyClient.getReleases("Bearer " + token);
    return ResponseEntity.ok(release.getAlbums().getItems());
    }
}
