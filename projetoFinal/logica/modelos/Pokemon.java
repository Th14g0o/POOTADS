package projetoFinal.logica.modelos;

public class Pokemon{
    private Long id;
    private String nome;
    private byte[] imagem;

    public void setImagem(byte[] imagem){
        this.imagem = imagem;
    }
    public byte[] getImagem(){
        return this.imagem;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
}
