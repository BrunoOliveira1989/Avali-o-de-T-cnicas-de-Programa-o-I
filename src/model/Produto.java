package model;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;


    //Método construtor
    public Produto ( int codigo , String nome , String descricao , double preco , int quantidadeEstoque ) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }


    //Getter and Setter
    public int getCodigo ( ) {
        return codigo;
    }

    public void setCodigo ( int codigo ) {
        this.codigo = codigo;
    }

    public String getNome ( ) {
        return nome;
    }

    public void setNome ( String nome ) {
        this.nome = nome;
    }

    public String getDescricao ( ) {
        return descricao;
    }

    public void setDescricao ( String descricao ) {
        this.descricao = descricao;
    }

    public double getPreco ( ) {
        return preco;
    }

    public void setPreco ( float preco ) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque ( ) {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque ( int quantidadeEstoque ) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    // Métodos
    public boolean retirarProduto ( int quantidade ) {
        if ( quantidadeEstoque > 0 ) {
            quantidadeEstoque -= quantidade;
            return true;
        }
        return false;
    }

    public boolean adicionarProduto ( int quantidade ) {
        if ( quantidadeEstoque > 0 ) {
            quantidadeEstoque += quantidade;
            return true;
        }
        return false;
    }

    public void exibirInformacoes ( ) {
        System.out.println ( "Código: " + codigo );
        System.out.println ( "Nome: " + nome );
        System.out.println ( "Descrição: " + descricao );
        System.out.println ( "Preço: R$" + preco );
        System.out.println ( "Quantidade em estoque: " + quantidadeEstoque );
    }
}
