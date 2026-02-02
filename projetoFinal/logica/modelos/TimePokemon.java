package projetoFinal.logica.modelos;

public class TimePokemon {
    private Long id;
    private Long idTime;
    private Long idPokemon;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setIdTime(Long idTime){
        this.idTime = idTime;
    }
    public Long getIdTime(){
        return this.idTime;
    }

    public void setIdPokemon(Long idPokemon){
        this.idPokemon = idPokemon;
    }
    public Long getIdPokemon(){
        return this.idPokemon;
    }
}
