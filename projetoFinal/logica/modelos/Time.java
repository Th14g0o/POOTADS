package projetoFinal.logica.modelos;

public class Time {
    private Long id;
    private String nome;
    private Long idJogo;

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

    public void setIdJogo(Long idJogo){
        this.idJogo = idJogo;
    }
    public Long getIdJogo(){
        return this.idJogo;
    }
}
