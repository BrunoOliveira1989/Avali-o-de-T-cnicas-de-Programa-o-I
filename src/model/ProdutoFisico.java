package model;

public class ProdutoFisico extends Produto {
    private double peso;
    private String dimensao;


    //Método construtor
    public ProdutoFisico ( int codigo , String nome , String descricao , double preco , int quantidadeEstoque , double peso , String dimensao ) {
        super ( codigo , nome , descricao , preco , quantidadeEstoque );
        this.peso = peso;
        this.dimensao = dimensao;
    }


    //Getter and Setter
    public double getPeso ( ) {
        return peso;
    }

    public void setPeso ( double peso ) {
        this.peso = peso;
    }

    public String getDimensao ( ) {
        return dimensao;
    }

    public void setDimensao ( String dimensao ) {
        this.dimensao = dimensao;
    }


    // Método sobrescrito
    @Override
    public void exibirInformacoes ( ) {
        super.exibirInformacoes ( );
        System.out.println ( "Peso: " + peso + " kg" );
        System.out.println ( "Dimensões: " + dimensao );
    }
}
