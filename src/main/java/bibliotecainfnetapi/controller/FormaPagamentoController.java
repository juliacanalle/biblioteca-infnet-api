package bibliotecainfnetapi.controller;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FormaPagamentoController {

    private final Scanner scanner = new Scanner(System.in);

    public void processarPagamentoCartao() {
        System.out.println("Informe o número do cartão:");
        String numero = scanner.nextLine();

        System.out.println("Informe o nome presente no cartão:");
        String nome = scanner.nextLine();

        System.out.println("Informe a data de vencimento (MM/AA):");
        String vencimento = scanner.nextLine();

        System.out.println("Informe o código de segurança (CVV):");
        String cvv = scanner.nextLine();

        System.out.println("Pagamento com cartão realizado com sucesso.");
    }

    public void processarPagamentoBoleto() {
        String codigoBoleto = "34191.79001 " + (int)(Math.random() * 1000000000);
        System.out.println("Boleto gerado: " + codigoBoleto);
        System.out.println("Pagamento via boleto aguardando confirmação.");
    }

    public void processarPagamentoPix() {
        String chavePix = "pix-" + System.currentTimeMillis();
        System.out.println("Chave Pix gerada: " + chavePix);
        System.out.println("Realize a transferência para concluir o pagamento.");
    }
}
