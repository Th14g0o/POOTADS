package projetoFinal.logica.modelos;

public class PokemonElemento {
    private Long id;
    private Long idPokemon;
    private Long idElemento;
    private Long idJogo;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setIdPokemon(Long idPokemon){
        this.idPokemon = idPokemon;
    }
    public Long getIdPokemon(){
        return this.idPokemon;
    }

    public void setIdElemento(Long idElemento){
        this.idElemento = idElemento;
    }
    public Long getIdElemento(){
        return this.idElemento;
    }

    public void setIdJogo(Long idJogo){
        this.idJogo = idJogo;
    }
    public Long getIdJogo(){
        return this.idJogo;
    }
}
