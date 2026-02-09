package projetoFinal.logica.modelos;

public class Evolucao{
    private Long id;
    private Long idPokemon;
    private int estagio;
    private Long idEvolucao;
    private int estagioEvolucao;
    private String requisitos;
    private Long idJogo;

    public void setEstagioEvolucao(int estagioEvolucao){
        this.estagioEvolucao = estagioEvolucao;
    }
    public int getEstagioEvolucao(){
        return this.estagioEvolucao;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setIdJogo(Long idJogo){
        this.idJogo = idJogo;
    }
    public Long getIdJogo(){
        return this.idJogo;
    }

    public void setPokemonId(Long idPokemon){
        this.idPokemon = idPokemon;
    }
    public Long getPokemonId(){
        return this.idPokemon;
    }

    public void setEstagio(int estagio){
        this.estagio = estagio;
    }
    public int getEstagio(){
        return this.estagio;
    }

    public void setEvolucaoId(Long idEvolucao){
        this.idEvolucao = idEvolucao;
    }
    public Long getEvolucaoId(){
        return this.idEvolucao;
    }

    public void setRequisitos(String requisitos){
        this.requisitos = requisitos;
    }
    public String getRequisitos(){
        return this.requisitos;
    }
}