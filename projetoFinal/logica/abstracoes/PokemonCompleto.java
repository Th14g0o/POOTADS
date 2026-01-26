package projetoFinal.logica.abstracoes;

import java.util.List;
import projetoFinal.logica.interfaces.IPokemonCompleto;

public abstract class PokemonCompleto implements IPokemonCompleto {
    protected String nome;
    protected String descricaoPokemon;
    protected int numero;
    protected String estagio;
    protected String requisitos;
    protected List<ElementoCompleto> elementos;
    protected List<PokemonCompleto> evolucoes;

    public void setNome(String x){}
    public void setEvolucao(String x){}
    public void setElementos(String x){}
}
