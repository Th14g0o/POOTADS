package projetoFinal.logica.modelos;

import projetoFinal.logica.abstracoes.ElementoCompleto;

public class Elemento extends ElementoCompleto{
    @Override
    public String toString(){
        return getNome();
    }
}