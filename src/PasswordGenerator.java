import java.util.Random;

public class PasswordGenerator {

    static String generatedPass;
    static String minuscula = "abcdefghijklmnopqrstuvwxyz";
    static String mayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numeros = "0123456789";
    static String simbolos = "!@#$%^&*()_+-=";
    static String combinados = minuscula + mayuscula;
    static String alfabeto;

    public String passwordGenerator(Integer passLength, String letterCase, Boolean numbersOption, Boolean symbolsOption){

        StringBuilder gpBuilder = new StringBuilder();
        int length = passLength;
        char[] passArray = new char[length];
        if (letterCase.equals("LOWERCASE") && !numbersOption && !symbolsOption){
            alfabeto = minuscula;
        } else if (letterCase.equals("LOWERCASE") && !numbersOption){
            alfabeto = minuscula + simbolos;
        } else if (letterCase.equals("LOWERCASE") && !symbolsOption){
            alfabeto = minuscula + numeros;
        } else if (letterCase.equals("LOWERCASE")){
            alfabeto = minuscula + simbolos + numeros;
        }

        if (letterCase.equals("UPPERCASE") && !numbersOption && !symbolsOption){
            alfabeto = mayuscula;
        } else if (letterCase.equals("UPPERCASE") && !numbersOption){
            alfabeto = mayuscula + simbolos;
        } else if (letterCase.equals("UPPERCASE") && !symbolsOption){
            alfabeto = mayuscula + numeros;
        } else if (letterCase.equals("UPPERCASE")){
            alfabeto = mayuscula + simbolos + numeros;
        }

        if (letterCase.equals("COMBINED") && !numbersOption && !symbolsOption){
            alfabeto = combinados;
        } else if (letterCase.equals("COMBINED") && !numbersOption){
            alfabeto = combinados + simbolos;
        } else if (letterCase.equals("COMBINED") && !symbolsOption){
            alfabeto = combinados + numeros;
        } else if (letterCase.equals("COMBINED")){
            alfabeto = combinados + simbolos + numeros;
        }

        for (int i = 0; i<length; i++){
            Random r = new Random();
            passArray[i] = alfabeto.charAt(r.nextInt(alfabeto.length()));
        }

        gpBuilder.append(passArray);
        generatedPass = gpBuilder.toString();

        return generatedPass;
    }
}
