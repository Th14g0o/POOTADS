package projetoFinal.logica.abstracoes;

public abstract class PokemonPokedex {
    protected Long id;
    protected String nomePokemon;
    protected byte[] imagemPokemon;
    protected String nomeJogo;
    protected String nomeRegiao;
    protected String descricaoPokemon;
    protected int numeroPokemon;
    protected int estagio;
    protected String requisitos;
    protected String cor;
    protected Long idJogo;
    protected Long idPokemon;

    public Long getIdJogo() {
        return idJogo;
    }
    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdPokemon() {
        return idPokemon;
    }
    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public int getEstagio() {
        return estagio;
    }
    public void setEstagio(int estagio) {
        this.estagio = estagio;
    }

    public String getRequisitos() {
        return requisitos;
    }
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }
    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }
    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }
    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public void setImagemPokemon(byte[] imagemPokemon){
        this.imagemPokemon = imagemPokemon;
    }
    public byte[] getImagemPokemon(){
        return this.imagemPokemon;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPokemon() {
        return numeroPokemon;
    }
    public void setNumeroPokemon(int numeroPokemon) {
        this.numeroPokemon = numeroPokemon;
    }

    public String getDescricaoPokemon() {
        return descricaoPokemon;
    }
    public void setDescricaoPokemon(String descricaoPokemon) {
        this.descricaoPokemon = descricaoPokemon;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
