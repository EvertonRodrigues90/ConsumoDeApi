package apiConnect;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface ApiConnectService {

    public HttpResponse<String> connectToApi(String endereco) throws IOException, InterruptedException;
}
