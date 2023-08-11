package apiConnect;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TmdbConnect implements ApiConnectService {

    private static  String API_BASE_URL = "https://api.themoviedb.org/3/search/movie?query=";

    private static  String API_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMjkwM2NiOTVlYmI3OWFhYzFlZTdiNzIzMDg0N2MwNiIsInN1YiI6IjY0ZDM3N2JkMDM3MjY0MDExYzA1NmJmNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TJL8tn0MASgwZLSCDzYByxGk1la67Lu5TGOkditI7qY"; // Substitua pela sua própria chave de API

    @Override
     public HttpResponse<String> connectToApi(String busca) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL+ busca+ "&include_adult=false&language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return  response;
        }

    public static String getApiBaseUrl() {
        return API_BASE_URL;
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
