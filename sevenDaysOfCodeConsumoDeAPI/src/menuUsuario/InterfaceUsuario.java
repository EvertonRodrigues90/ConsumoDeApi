package menuUsuario;


import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario(){
        scanner = new Scanner(System.in);
    }


    public String getOption(){
        System.out.println("Deseja buscar por NOME, ANO DE LANÇAMENTO ou VÁRIOS RELACIONADOS AO NOME?");
        System.out.println("DIGITE NOME para nome, ANO para ano de lançamento,  VARIOS ou SAIR para encerrar: ");
        String option =  scanner.nextLine();
        if(validaOption(option)){
            return option;
        }else
           return getOption();
    }

    public String getSearchQuery(String option){
        if(validaOption(option)){
            System.out.println("Digite oque deseja buscar: ");
            return scanner.nextLine();
        }else
            System.out.println("Opção inválida");
        return getOption();
    }

    public boolean validaOption(String option){
        if(option.equalsIgnoreCase("nome") || option.equalsIgnoreCase("ano") || option.equalsIgnoreCase("varios") || option.equalsIgnoreCase("sair")){
            return true;
        }else
            return false;
    }


    public String getYearIfApplicable(String option){
        if(option.equalsIgnoreCase("ano")){
            System.out.println("Digite o ano de lançamento: ");
           return scanner.nextLine();
        }else
            return null;
    }


}
