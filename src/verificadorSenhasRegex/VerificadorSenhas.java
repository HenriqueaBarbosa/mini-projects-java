package verificadorSenhasRegex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class VerificadorSenhas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String senha;
        boolean senhaAtendeRequisitos = false;

        while (!senhaAtendeRequisitos) {
            System.out.print("Digite uma senha que atenda a todos os requisitos: ");
            senha = scanner.nextLine();
            senhaAtendeRequisitos = verificarForcaSenha(senha);

            if (!senhaAtendeRequisitos) {
                System.out.println("A senha não atende aos requisitos de segurança. Por favor, tente novamente.");
            }
        }

        System.out.println("Sua senha é forte e atende a todos os requisitos de segurança, senha cadastrada com sucesso!");

        scanner.close();
    }

    public static boolean verificarForcaSenha(String senha) {

        int comprimentoMinimo = 8;

        boolean atendeRequisitos = true;

        if (senha.length() < comprimentoMinimo) {
            System.out.println("A senha deve ter pelo menos " + comprimentoMinimo + " caracteres");
            atendeRequisitos = false;
        }

        boolean temLetraMaiuscula = Pattern.compile("[A-Z]").matcher(senha).find();
        if (!temLetraMaiuscula) {
            System.out.println("A senha deve conter ao menos uma letra maiúscula");
            atendeRequisitos = false;
        }

        boolean temLetraMinuscula = Pattern.compile("[a-z]").matcher(senha).find();
        if (!temLetraMinuscula) {
            System.out.println("A senha deve conter ao menos uma letra minúscula");
            atendeRequisitos = false;
        }

        boolean temNumero = Pattern.compile("\\d").matcher(senha).find();
        if (!temNumero) {
            System.out.println("A senha deve conter ao menos um número");
            atendeRequisitos = false;
        }

        boolean temCaractereEspecial = Pattern.compile("\\W").matcher(senha).find();
        if (!temCaractereEspecial) {
            System.out.println("A senha deve conter ao menos um caractere especial");
            atendeRequisitos = false;
        }

        boolean temSequenciaComum = senha.matches(".*(?i)123456.*|.*(?i)abcdef.*");
        if (temSequenciaComum) {
            System.out.println("A senha não deve conter uma sequência comum");
            atendeRequisitos = false;
        }

        //Pode ser acrescentado qualquer outra palavra que seja muito comum
        boolean temPalavraComum = senha.equalsIgnoreCase("password") ||
                senha.equalsIgnoreCase("123456") ||
                senha.equalsIgnoreCase("qwerty");
        if (temPalavraComum) {
            System.out.println("A senha não deve conter uma palavra comum");
            atendeRequisitos = false;
        }

        return atendeRequisitos;
    }
}