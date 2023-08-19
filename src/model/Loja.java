package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private final List < Produto > produtos = new ArrayList <> ( );

    // Métodos
    public void adicionarProduto ( Produto produto ) {
        produtos.add ( produto );
    }

    public void exibirInformacoesProduto ( int codigo ) throws ProdutoNaoEncontradoException {
        for ( Produto produto : produtos ) {
            if ( produto.getCodigo ( ) == codigo ) {
                produto.exibirInformacoes ( );
                return;
            }
        }
        throw new ProdutoNaoEncontradoException ( "Produto não encontrado na loja." );
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

    public Produto obterProduto ( int codigo ) throws ProdutoNaoEncontradoException {
        for ( Produto produto : produtos ) {
            if ( produto.getCodigo ( ) == codigo ) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException ( "Produto não encontrado na loja." );
    }

    public void gerarRelatorio ( ) {
        System.out.println ( "Relatório de produtos disponíveis:" );
        for ( Produto produto : produtos ) {
            produto.exibirInformacoes ( );
            System.out.println ( "---------------------------" );
        }
    }

    public void atualizarEstoque ( List < Produto > produtos ) throws ProdutoNaoEncontradoException {
        for ( Produto produtoCarrinho : produtos ) {
            //Produto produtoEstoque = obterProduto(produtoCarrinho.getCodigo());
            //produtoEstoque.setQuantidadeEstoque(produtoEstoque.getQuantidadeEstoque() - 1);
            produtoCarrinho.retirarProduto ( 1 );
        }
    }
}

