import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        String nomeCliente = "MARIO ANDRADE";
        String agencia = "067-8";
        int numero = 1021;
        double saldo = 237.48;

        int tentativa = 3;

        String agenciaDigitada;
        int numeroDigitado;

        Scanner dados = new Scanner(System.in);

            // Ambos os campos, agência e usuário, terão 
            // tolerância até três tentativas.

        try {    

            while (tentativa > 0) {
                System.out.println("Por favor, digite o número da Agência!");
                agenciaDigitada = dados.next();

                if (agenciaDigitada.equals(agencia)) {
                    tentativa = 3;
                    break;
                }
                if (!agenciaDigitada.equals(agencia) && tentativa > 0) {
                    System.out.println("Número de agência incorreta, tente novamente.\n" +
                            "Tentativas restantes " + (tentativa - 1));
                    tentativa--;
                }
                if (tentativa == 0) {
                    System.out.println("Dados não conferem.\n" +
                            "Por favor, entre em contato com sua instiuição bancária.");
                }
            }

            while (tentativa > 0) {
                System.out.println("Usuário:");
                numeroDigitado = dados.nextInt();

                if (numeroDigitado == numero) {
                    System.out.println("Olá " + nomeCliente +
                            ", obrigado por criar uma conta em nosso banco, sua agência é " +
                            agencia + ", conta, " + numero + " e seu saldo R$ " +
                            saldo + " já está disponível para saque.");
                    break;
                }

                if (numeroDigitado != numero && tentativa > 0) {
                    System.out.println("Número incorreto, tente novamente.\n" +
                            "Tentativas restantes " + (tentativa - 1));
                    tentativa--;
                }

                if (tentativa == 0) {
                    System.out.println("Dados não conferem.\n" +
                            "Por favor, entre em contato com sua instiuição bancária.");
                }
            }
             // Tratamento de um possível erro, caso digite carateres
             // no campo de número.

        } catch (InputMismatchException e) {
            System.out.println("Verifique o campo digitado e tente novamente");

        }
    }
}
