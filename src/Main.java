import model.*;
import view.*;
import java.util.Scanner;


public class Main {
    public static void main ( String[] args ) throws ProdutoNaoEncontradoException {
        Scanner scanner = new Scanner ( System.in );
        Loja loja = new Loja ( );
        Carrinho carrinho = new Carrinho ( );
        MenuLoja menuLoja = new MenuLoja ( loja );
        MenuCarrinho menuCarrinho = new MenuCarrinho ( carrinho , loja );

        // Adicionar produtos de exemplo ao estoque da loja
        adicionarProdutosExemplo ( loja );

        int opcao = 0;
        while ( opcao != 3 ) {
            System.out.println ( "=== MENU PRINCIPAL ===" );
            System.out.println ( "1. Loja" );
            System.out.println ( "2. Carrinho" );
            System.out.println ( "3. Sair" );
            System.out.print ( "Escolha uma opção: " );
            opcao = Integer.parseInt(scanner.nextLine());

            switch ( opcao ) {
                case 1:
                    menuLoja.executarMenu ( );
                    break;
                case 2:
                    menuCarrinho.executarMenu ( );
                    break;
                case 3:
                    System.out.println ( "Saindo do programa..." );
                    break;
                default:
                    System.out.println ( "Opção inválida. Tente novamente." );
            }
        }
    }

    private static void adicionarProdutosExemplo ( Loja loja ) {
        Produto produto1 = new Produto ( 1 , "Camiseta" , "Camiseta de algodão" , 39.99 , 10 );
        ProdutoFisico produto2 = new ProdutoFisico ( 2 , "Livro" , "Livro de ficção" , 59.99 , 5 , 0.5 , "20x15 cm" );
        ProdutoDigital produto3 = new ProdutoDigital ( 3 , "Música" , "Álbum em formato MP3" , 9.99 , 100 , "MP3" , 5.3 );
        Produto produto4 = new Produto ( 4 , "Calça Jeans" , "Calça jeans azul" , 89.99 , 8 );
        ProdutoFisico produto5 = new ProdutoFisico ( 5 , "Celular" , "Smartphone Android" , 1999.99 , 3 , 0.3 , "15x7 cm" );
        ProdutoDigital produto6 = new ProdutoDigital ( 6 , "E-book" , "Livro eletrônico" , 19.99 , 50 , "PDF" , 2.8 );
        Produto produto7 = new Produto ( 7 , "Tênis" , "Tênis esportivo" , 149.99 , 12 );
        ProdutoFisico produto8 = new ProdutoFisico ( 8 , "DVD" , "Filme em DVD" , 29.99 , 7 , 0.1 , "12x12 cm" );
        ProdutoDigital produto9 = new ProdutoDigital ( 9 , "Software" , "Software de edição de imagens" , 99.99 , 20 , "EXE" , 150.5 );
        Produto produto10 = new Produto ( 10 , "Bolsa" , "Bolsa de couro" , 79.99 , 6 );
        ProdutoFisico produto11 = new ProdutoFisico ( 11 , "Óculos de Sol" , "Óculos de sol de marca" , 129.99 , 4 , 0.2 , "15x5 cm" );
        ProdutoDigital produto12 = new ProdutoDigital ( 12 , "Jogo" , "Jogo de computador" , 49.99 , 30 , "ISO" , 4.6 );
        Produto produto13 = new Produto ( 13 , "Jaqueta" , "Jaqueta corta-vento" , 99.99 , 9 );
        ProdutoFisico produto14 = new ProdutoFisico ( 14 , "Câmera" , "Câmera digital" , 799.99 , 2 , 0.8 , "10x8 cm" );
        ProdutoDigital produto15 = new ProdutoDigital ( 15 , "Filme Online" , "Filme para streaming" , 6.99 , 200 , "MP4" , 1.2 );

        loja.adicionarProduto ( produto1 );
        loja.adicionarProduto ( produto2 );
        loja.adicionarProduto ( produto3 );
        loja.adicionarProduto ( produto4 );
        loja.adicionarProduto ( produto5 );
        loja.adicionarProduto ( produto6 );
        loja.adicionarProduto ( produto7 );
        loja.adicionarProduto ( produto8 );
        loja.adicionarProduto ( produto9 );
        loja.adicionarProduto ( produto10 );
        loja.adicionarProduto ( produto11 );
        loja.adicionarProduto ( produto12 );
        loja.adicionarProduto ( produto13 );
        loja.adicionarProduto ( produto14 );
        loja.adicionarProduto ( produto15 );
    }
}
