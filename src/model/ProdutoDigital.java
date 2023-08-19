package model;

public class ProdutoDigital extends Produto {
    private String formato;
    private double tamanhoArquivo;


    //Método construtor
    public ProdutoDigital ( int codigo , String nome , String descricao , double preco , int quantidadeEstoque ,
                            String formato , double tamanhoArquivo ) {
        super ( codigo , nome , descricao , preco , quantidadeEstoque );
        this.formato = formato;
        this.tamanhoArquivo = tamanhoArquivo;
    }


    //Getter and Setter
    public String getFormato ( ) {
        return formato;
    }

    public void setFormato ( String formato ) {
        this.formato = formato;
    }

    public double getTamanhoArquivo ( ) {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo ( double tamanhoArquivo ) {
        this.tamanhoArquivo = tamanhoArquivo;
    }


    // Método sobrescrito
    @Override
    public void exibirInformacoes ( ) {
        super.exibirInformacoes ( );
        System.out.println ( "Formato: " + formato );
        System.out.println ( "Tamanho do arquivo: " + tamanhoArquivo + " MB" );
    }
}
