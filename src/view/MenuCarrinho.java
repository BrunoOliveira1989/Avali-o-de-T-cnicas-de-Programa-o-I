package view;

import model.*;
import java.util.Scanner;

public class MenuCarrinho {
    //private final Scanner scanner;
    Scanner scanner = new Scanner ( System.in );
    private final Carrinho carrinho;
    private final Loja loja;


    //Método construtor
    public MenuCarrinho ( Carrinho carrinho , Loja loja ) {
        this.scanner = scanner;
        this.carrinho = carrinho;
        this.loja = loja;
    }

    private static void adicionarProdutoAoCarrinho ( Scanner scanner , Carrinho carrinho , Loja loja ) {
        System.out.print ( "Digite o código do produto: " );
        int codigo = Integer.parseInt(scanner.nextLine());

        try {
            Produto produto = loja.obterProduto ( codigo );
            carrinho.adicionarProduto ( produto );
            System.out.println ( "Produto adicionado ao carrinho." );
        } catch ( ProdutoNaoEncontradoException e ) {
            System.out.println ( e.getMessage ( ) );
        }
    }

    private static void removerProdutoDoCarrinho ( Scanner scanner , Carrinho carrinho ) throws ProdutoNaoEncontradoException {
        System.out.print ( "Digite o código do produto: " );
        int codigo = Integer.parseInt(scanner.nextLine());
        carrinho.removerProduto ( codigo );
        System.out.println ( "Produto removido do carrinho." );
    }

    private static void exibirCarrinho ( Carrinho carrinho ) {
        System.out.println ( "=== CARRINHO ===" );
        for ( Produto produto : carrinho.getProdutos ( ) ) {
            System.out.println ( produto.getNome ( ) );
        }
        System.out.println ( "================" );
    }

    private static void calcularValorTotalCompra ( Carrinho carrinho ) {
        double valorTotal = carrinho.calcularValorTotal ( );
        System.out.println ( "Valor total da compra: R$ " + valorTotal );
    }

    private void efetuarCompra ( Carrinho carrinho , Loja loja ) {
        try {
            loja.atualizarEstoque ( carrinho.getProdutos ( ) );
            carrinho.esvaziarCarrinho ( );
            System.out.println ( "Compra efetuada com sucesso. O estoque foi atualizado." );
        } catch ( ProdutoNaoEncontradoException e ) {
            System.out.println ( e.getMessage ( ) );
        }
    }

    public void executarMenu ( ) throws ProdutoNaoEncontradoException {
        int opcao = 0;
        while ( opcao != 5 ) {
            System.out.println ( "=== MENU CARRINHO ===" );
            System.out.println ( "1. Adicionar produto ao carrinho" );
            System.out.println ( "2. Remover produto do carrinho" );
            System.out.println ( "3. Exibir carrinho" );
            System.out.println ( "4. Calcular valor total da compra" );
            System.out.println ( "5. Efetuar Compra" );
            System.out.println ( "6. Voltar ao menu principal" );
            System.out.println ( "7. Sair" );
            System.out.print ( "Escolha uma opção: " );
            opcao = Integer.parseInt(scanner.nextLine());

            switch ( opcao ) {
                case 1:
                    adicionarProdutoAoCarrinho ( scanner , carrinho , loja );
                    break;
                case 2:
                    removerProdutoDoCarrinho ( scanner , carrinho );
                    break;
                case 3:
                    exibirCarrinho ( carrinho );
                    break;
                case 4:
                    calcularValorTotalCompra ( carrinho );
                    break;
                case 5:
                    efetuarCompra ( carrinho , loja );
                    break;
                case 6:
                    System.out.println ( "Voltando ao menu principal..." );
                    break;
                case 7:
                    System.out.println ( "Saindo do programa..." );
                    break;
                default:
                    System.out.println ( "Opção inválida. Tente novamente." );
            }
        }
    }
}
