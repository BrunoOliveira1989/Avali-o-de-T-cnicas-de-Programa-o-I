package view;

import model.*;
import java.util.Scanner;

public class MenuLoja {
    //private final Scanner scanner;
    Scanner scanner = new Scanner ( System.in );
    private final Loja loja;

    public MenuLoja ( Loja loja ) {
        this.scanner = scanner;
        this.loja = loja;
    }

    private void cadastrarProduto ( ) {
        System.out.print ( "Digite o código do produto: " );
        int codigo = Integer.parseInt(scanner.nextLine());

        System.out.print ( "Digite o nome do produto: " );
        String nome = scanner.nextLine ( );

        System.out.print ( "Digite o descrição do produto: " );
        String descricao = scanner.nextLine ( );

        System.out.print ( "Digite o preço do produto: " );
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print ( "Digite a quantidade de produto: " );
        int quantidadeEstoque = Integer.parseInt(scanner.nextLine());

        System.out.print ( "O produto é físico (F) ou digital (D)? " );
        String tipo = scanner.nextLine ( );

        Produto produto;
        if ( tipo.equalsIgnoreCase ( "F" ) ) {
            System.out.print ( "Digite o peso do produto físico: " );
            double peso = Double.parseDouble(scanner.nextLine());

            System.out.print ( "Digite a dimensão do produto físico: " );
            String dimensao = scanner.nextLine ( );

            produto = new ProdutoFisico ( codigo , nome , descricao , preco , quantidadeEstoque , peso , dimensao );

        } else if ( tipo.equalsIgnoreCase ( "D" ) ) {
            System.out.print ( "Digite o formato do arquivo do produto digital: " );
            String formato = scanner.nextLine ( );

            System.out.print ( "Digite o tamanho do arquivo do produto digital: " );
            double tamanhoArquivo = Double.parseDouble(scanner.nextLine());

            produto = new ProdutoDigital ( codigo , nome , descricao , preco , quantidadeEstoque , formato , tamanhoArquivo );

        } else {
            System.out.println ( "Tipo de produto inválido." );
            return;
        }

        loja.adicionarProduto ( produto );
        System.out.println ( "Produto cadastrado com sucesso." );
    }

    private void exibirInformacoesProduto ( ) {
        System.out.print ( "Digite o código do produto: " );
        int codigo = Integer.parseInt(scanner.nextLine());

        try {
            loja.exibirInformacoesProduto ( codigo );
        } catch ( ProdutoNaoEncontradoException e ) {
            System.out.println ( e.getMessage ( ) );
        }
    }

    private void removerProduto ( ) {
        System.out.print ( "Digite o código do produto: " );
        int codigo = Integer.parseInt(scanner.nextLine());

        try {
            loja.removerProduto ( codigo );
            System.out.println ( "Produto removido com sucesso." );
        } catch ( ProdutoNaoEncontradoException e ) {
            System.out.println ( e.getMessage ( ) );
        }
    }

    private void gerarRelatorio ( ) {
        loja.gerarRelatorio ( );
    }

    public void executarMenu ( ) {
        int opcao = 0;
        while ( opcao != 5 ) {
            System.out.println ( "=== MENU LOJA ===" );
            System.out.println ( "1. Cadastrar produto" );
            System.out.println ( "2. Exibir informações de um produto" );
            System.out.println ( "3. Remover produto" );
            System.out.println ( "4. Gerar relatório de produtos disponíveis" );
            System.out.println ( "5. Voltar ao menu principal" );
            System.out.print ( "Escolha uma opção: " );
            opcao = Integer.parseInt(scanner.nextLine());

            switch ( opcao ) {
                case 1:
                    cadastrarProduto ( );
                    break;
                case 2:
                    exibirInformacoesProduto ( );
                    break;
                case 3:
                    removerProduto ( );
                    break;
                case 4:
                    gerarRelatorio ( );
                    break;
                case 5:
                    System.out.println ( "Voltando ao menu principal..." );
                    break;
                default:
                    System.out.println ( "Opção inválida. Tente novamente." );
            }
        }
    }
}