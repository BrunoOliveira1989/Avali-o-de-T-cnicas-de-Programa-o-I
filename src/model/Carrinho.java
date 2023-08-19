package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List < Produto > produtos = new ArrayList <> ( );

    //Getter and Setter
    public List < Produto > getProdutos ( ) {
        return produtos;
    }

    public void setProdutos ( List < Produto > produtos ) {
        this.produtos = produtos;
    }


    // Métodos
    public void adicionarProduto ( Produto produto ) {
        produtos.add ( produto );
        System.out.println ( "Produto adicionado ao carrinho: " + produto.getNome ( ) );
    }

    public void removerProduto ( int codigo ) throws ProdutoNaoEncontradoException {
        Produto produtoRemovido = null;
        for ( Produto produto : produtos ) {
            if ( produto.getCodigo ( ) == codigo ) {
                produtoRemovido = produto;
                break;
            }
        }
        if ( produtoRemovido != null ) {
            produtos.remove ( produtoRemovido );
            System.out.println ( "Produto removido do carrinho: " + produtoRemovido.getNome ( ) );
        } else {
            throw new ProdutoNaoEncontradoException ( "Produto não encontrado no carrinho." );
        }
    }

    public double calcularValorTotal ( ) {
        double valorTotal = 0;
        for ( Produto produto : produtos ) {
            valorTotal += produto.getPreco ( );
        }
        return valorTotal;
    }

    public void esvaziarCarrinho ( ) {
        produtos.clear ( );
    }
}