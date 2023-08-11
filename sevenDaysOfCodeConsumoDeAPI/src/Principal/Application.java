package Principal;

import Util.CreateFile;
import Util.HTMLGenerator;
import apiConnect.ApiConnectService;
import apiConnect.OmdbConnect;
import apiConnect.TmdbConnect;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import menuUsuario.InterfaceUsuario;
import modelos.Titulo;
import modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        PrintWriter writer = new PrintWriter("titulos.html");
        HTMLGenerator htmlGenerator = new HTMLGenerator(writer);


        String apiKey = "&apikey=eeeffd17";
        String buscarPor = "";
        String nomeDoTitulo = "?t=";
        String buscarPorAno = "&y=";
        String buscarPorRelacionados = "?s=";
        String busca = "";
        String ano = "";
        String endereco = "";
        List<Titulo> filmes = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> anoLancamento = new ArrayList<>();
        List<String> genre = new ArrayList<>();
        String API_BASE_URL = "https://api.themoviedb.org/3/search/movie?api_key=";
        String API_KEY = "c2903cb95ebb79aac1ee7b7230847c06";
        String enderecoTmdb = API_BASE_URL + API_KEY;


        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

             buscarPor = interfaceUsuario.getOption();


        while (!buscarPor.equalsIgnoreCase("sair")) {
            busca = interfaceUsuario.getSearchQuery(buscarPor);
            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            ano = interfaceUsuario.getYearIfApplicable(buscarPor);

            if(buscarPor.equalsIgnoreCase("nome")){
                endereco = "https://omdbapi.com/" + nomeDoTitulo + busca.replace(" ", "+") + apiKey;
            } else if (buscarPor.equalsIgnoreCase("ano")) {
                endereco = "https://omdbapi.com/"+ nomeDoTitulo + busca.replace(" ","+") + buscarPorAno + ano + apiKey;

            } else if (buscarPor.equalsIgnoreCase("varios")) {
                endereco = "https://omdbapi.com/"+  buscarPorRelacionados  + busca.replace(" ","+") + apiKey;

            }else{
                System.out.println("Busca inválida");
            }

            ApiConnectService connectService = new OmdbConnect();
            ApiConnectService connectService1 = new TmdbConnect();

            HttpResponse<String> tmdbResponse = connectService1.connectToApi(busca);

            System.out.println("TMDB" + tmdbResponse.body());

            HttpResponse<String> response = connectService.connectToApi(endereco);

            System.out.println(response.body());

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

            //Titulo que esta vindo da resposta da api OMDB e sendo desserealizado
            TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

            //Titulo desserealizado e convertido para uma classe do programa
            Titulo titulo = new Titulo(meuTituloOmdb);

            filmes.add(titulo);

            CreateFile fileCreate = new CreateFile();

            fileCreate.createFile(gson, filmes);
        }

        System.out.println(filmes);

        htmlGenerator.generate(filmes);

        writer.close();
    }
}

