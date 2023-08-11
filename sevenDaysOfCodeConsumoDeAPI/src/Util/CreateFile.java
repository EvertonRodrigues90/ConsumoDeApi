package Util;

import com.google.gson.Gson;
import modelos.Titulo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFile {

    public void createFile(Gson gson, List<Titulo> filmes) throws IOException {
        FileWriter writing = new FileWriter("filmes.json");
        writing.write(gson.toJson(filmes));
        writing.close();

    }

}
