package projetoFinal.logica.abstracoes;

public abstract class ElementoCompleto {
    protected Long id;
    protected String nome;
    protected String cor;
    protected byte[] imagem;

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

    public void setCor(String cor){
        this.cor = cor;
    }
    public String getCor(){
        return this.cor;
    }
}
