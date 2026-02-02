package projetoFinal.logica.modelos;

public class Pokedex {
    private Long  id;
    private int numeroPokemon;
    private String descricaoPokemon;
    private String cor;
    private Long idAnterior;
    private Long idProximo;
    private Long idPokemon;
    private Long idJogo;
    private Long idRegiao;

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

    public Long getIdAnterior() {
        return idAnterior;
    }
    public void setIdAnterior(Long idAnterior) {
        this.idAnterior = idAnterior;
    }

    public Long getIdProximo() {
        return idProximo;
    }
    public void setIdProximo(Long idProximo) {
        this.idProximo = idProximo;
    }

    public Long getIdPokemon() {
        return idPokemon;
    }
    public void setIdPokemon(Long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Long getIdJogo() {
        return idJogo;
    }
    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdRegiao() {
        return idRegiao;
    }
    public void setIdRegiao(Long idRegiao) {
        this.idRegiao = idRegiao;
    }

}
