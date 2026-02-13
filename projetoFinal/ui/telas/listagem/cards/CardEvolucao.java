package projetoFinal.ui.telas.listagem.cards;

import javax.swing.*;
import java.awt.*;
import projetoFinal.logica.dto.EvolucaoDTO;
import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.logica.servicos.ServicosPokemon;
import projetoFinal.ui.formularios.CadastroEvolucao;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupEdicao;
import projetoFinal.ui.telas.listagem.cards.popup.PopPupExclusao;
import projetoFinal.ui.util.Imagens;

public class CardEvolucao extends CardListagemModelo<EvolucaoDTO>{
    public CardEvolucao(int iconeAcoesLargura, int iconeAcoesAltura, EvolucaoDTO obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        setModelo(obj);
    }

    public void mostrarExclusão(){
        String nome = "a evolução";
        if (obj != null && obj.getPokemon() != null) nome = obj.getPokemon().getNome();
        PopPupExclusao ppe = new PopPupExclusao("Excluir Evolução", this, nome);
        ppe.mostrar(true);
    }

    public void mostrarEdicao(){
        CadastroEvolucao form = new CadastroEvolucao(false, obj != null ? obj.getEvolucao() : null);
        PopPupEdicao<Evolucao> ppe = new PopPupEdicao("Editar Evolução", this, form);
        ppe.mostrar(true);
    }

    public void apagar(){
        if (this.obj != null && this.obj.getEvolucao() != null) ServicosPokemon.apagarEvolucao(this.obj.getEvolucao().getId());
        this.obj = null;
        conteudoCard.setVisible(false);
        setVisible(false);
    }

    public void recarregarConteudo(){
        this.limparConteudoCard();
        if (this.obj != null && this.obj.getEvolucao() != null) setModelo(ServicosPokemon.acharEvolucaoDTO(this.obj.getEvolucao().getId()));
        conteudoCard.revalidate();
        conteudoCard.repaint();
    }

    public void setModelo(EvolucaoDTO obj){
        if (obj != null) gerarConteudo(obj);
    }

    protected void gerarConteudo(EvolucaoDTO obj){
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        JPanel painelHorizotal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelHorizotal.setOpaque(false);
        painelHorizotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelHorizotal.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(painelHorizotal);

        JPanel cardPokemon = new JPanel();
        cardPokemon.setLayout(new BoxLayout(cardPokemon, BoxLayout.PAGE_AXIS));
        cardPokemon.setOpaque(false);
        cardPokemon.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardPokemon.setAlignmentY(Component.TOP_ALIGNMENT);
        painelHorizotal.add(cardPokemon);

        if (obj.getPokemon().getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getPokemon().getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            cardPokemon.add(imagem);  
        }
        else{
            cardPokemon.add(Box.createRigidArea(new Dimension(0,50)));
        }

        cardPokemon.add(Box.createRigidArea(new Dimension(0,5)));

        JLabel estagios = new JLabel("Estagio: " + obj.getEvolucao().getEstagio()); 
        estagios.setForeground(Color.WHITE);
        estagios.setOpaque(false);
        estagios.setAlignmentX(Component.CENTER_ALIGNMENT);
        estagios.setAlignmentY(Component.CENTER_ALIGNMENT);
        cardPokemon.add(estagios);

        cardPokemon.add(Box.createRigidArea(new Dimension(0,5)));

        JLabel texto = new JLabel(obj.getPokemon().getNome()); 
        texto.setForeground(Color.WHITE);
        texto.setOpaque(false);
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        texto.setAlignmentY(Component.CENTER_ALIGNMENT);
        cardPokemon.add(texto);

        cardPokemon.add(Box.createRigidArea(new Dimension(0,5)));

        if (obj.getPokemon().getImagem() == null)  cardPokemon.add(Box.createRigidArea(new Dimension(0,50)));

        painelHorizotal.add(Box.createRigidArea(new Dimension(20,0)));

        JPanel cardEvolucao = new JPanel();
        cardEvolucao.setLayout(new BoxLayout(cardEvolucao, BoxLayout.PAGE_AXIS));
        cardEvolucao.setOpaque(false);
        cardEvolucao.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardEvolucao.setAlignmentY(Component.TOP_ALIGNMENT);
        painelHorizotal.add(cardEvolucao);

        if (obj.getPokeEvolucao().getImagem() != null){
            JLabel imagem;
            imagem = new JLabel(Imagens.escalaIcone(obj.getPokeEvolucao().getImagem(), 100, 100));
            imagem.setOpaque(false);
            imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagem.setAlignmentY(Component.CENTER_ALIGNMENT);
            cardEvolucao.add(imagem);  
            
        }
        else{
            cardEvolucao.add(Box.createRigidArea(new Dimension(0,50)));
        }

        cardEvolucao.add(Box.createRigidArea(new Dimension(0,5)));

        JLabel estagiosEvolucao = new JLabel("Estagio: " + obj.getEvolucao().getEstagioEvolucao()); 
        estagiosEvolucao.setForeground(Color.WHITE);
        estagiosEvolucao.setOpaque(false);
        estagiosEvolucao.setAlignmentX(Component.CENTER_ALIGNMENT);
        estagiosEvolucao.setAlignmentY(Component.CENTER_ALIGNMENT);
        cardEvolucao.add(estagiosEvolucao);

        cardEvolucao.add(Box.createRigidArea(new Dimension(0,5)));

        JLabel textoEvolucao = new JLabel(obj.getPokeEvolucao().getNome()); 
        textoEvolucao.setForeground(Color.WHITE);
        textoEvolucao.setOpaque(false);
        textoEvolucao.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoEvolucao.setAlignmentY(Component.CENTER_ALIGNMENT);
        cardEvolucao.add(textoEvolucao);

        cardEvolucao.add(Box.createRigidArea(new Dimension(0,5)));

        if (obj.getPokeEvolucao().getImagem() == null)  cardEvolucao.add(Box.createRigidArea(new Dimension(0,50)));

        JLabel requisitos = new JLabel(obj.getPokemon().getNome()); 
        requisitos.setForeground(Color.WHITE);
        requisitos.setOpaque(false);
        requisitos.setPreferredSize(new Dimension(50, 50));
        requisitos.setAlignmentX(Component.CENTER_ALIGNMENT);
        requisitos.setAlignmentY(Component.CENTER_ALIGNMENT);
        leiaute.add(requisitos);
    }
    
}
