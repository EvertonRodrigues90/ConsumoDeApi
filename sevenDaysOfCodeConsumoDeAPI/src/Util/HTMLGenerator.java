package Util;

import modelos.Titulo;

import javax.swing.text.html.HTML;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.List;

public class HTMLGenerator {

    private PrintWriter writer;

    public HTMLGenerator(PrintWriter writer){
        this.writer = writer;
    }

    public void generate(List<Titulo> titulos){
        writerHeader();
        writerMovies(titulos);
        writerFooter();

    }

    private void writerHeader() {
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>Filmes</title>");
        writer.println("<style>");
        writer.println(".card {");
        writer.println("    border: 1px solid #ccc;");
        writer.println("    padding: 10px;");
        writer.println("    margin: 10px;");
        writer.println("    width: 300px;");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Lista de Filmes</h1>");
        writer.println("<ul>");
    }


    private void writerMovies(List<Titulo> titulos) {
        for (Titulo titulo : titulos) {
            writer.println("<li>");
            writer.println("<div class=\"card\">");
            writer.println("<strong>Título:</strong> " + titulo.getNome() + "<br>");
            writer.println("<strong>Duração:</strong> " + titulo.getDuracao() + "<br>");
            writer.println("<strong>Ano:</strong> " + titulo.getAnoDeLancamento() + "<br>");
            writer.println("<strong>Avaliação:</strong>" + titulo.getRated() +"<br>");
            writer.println("</div");
            writer.println("</li>");
        }
    }

    private void writerFooter() {
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }






}
