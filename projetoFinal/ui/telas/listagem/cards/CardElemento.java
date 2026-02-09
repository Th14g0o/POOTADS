package projetoFinal.ui.telas.listagem.cards;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.servicos.ServicosElemento;
import projetoFinal.ui.componentes.PopPup;
import projetoFinal.ui.componentes.TagElementoArredondada;
import projetoFinal.ui.componentes.botoes.BotaoVermelho;
import projetoFinal.ui.formularios.CadastroElemento;
import projetoFinal.ui.interfaces.AoClicar;
import projetoFinal.ui.telas.listagem.cards.abstracao.CardListagemModelo;
import projetoFinal.ui.util.Cores;

public class CardElemento extends CardListagemModelo<Elemento> {
    
    public CardElemento(int iconeAcoesLargura, int iconeAcoesAltura, Elemento obj){
        super(iconeAcoesLargura, iconeAcoesAltura);
        this.iconeAcoesAltura = iconeAcoesAltura;
        this.iconeAcoesLargura = iconeAcoesLargura;
        
        setModelo(obj);

        btEditar.addActionListener(e -> {
            mostrarEdicao();  
        });

        btApagar.addActionListener(e -> {
            mostrarExclusão();  
        });
        
    }

    public void mostrarExclusão(){
        JPanel conteudoPP = new JPanel();
        conteudoPP.setBackground(Cores.AZUL);

        JLabel texto = new JLabel("Tem certeza que deseja excluir " + (obj != null ? obj.getNome() : "o elemento") + "?");
        texto.setOpaque(false);
        texto.setForeground(Color.WHITE);
        conteudoPP.add(texto);

        PopPup pp = new PopPup("Exclusão de Elemento", this, conteudoPP);
        BotaoVermelho ok = new BotaoVermelho("Confirmar", Cores.VERDE, Color.WHITE);
        BotaoVermelho cancelar = new BotaoVermelho("Cancelar", Cores.VERMELHO, Color.WHITE);
        pp.addBotao(
            ok, true, 
            new AoClicar() {
                public void acao() { apagar(); }
            }
        );
        pp.addBotao(
            cancelar, true,
            new AoClicar() {
                public void acao() { recarregarConteudo(); }
            }
        );
        pp.mostrar(true);
    }

    public void mostrarEdicao(){
        PopPup pp = new PopPup("Edição de Elemento", this, new CadastroElemento(false, obj));
        BotaoVermelho ok = new BotaoVermelho("Confirmar", Cores.VERDE, Color.WHITE);
        BotaoVermelho cancelar = new BotaoVermelho("Cancelar", Cores.VERMELHO, Color.WHITE);
        pp.addBotao(
            ok, true, 
            new AoClicar() {
                public void acao() { recarregarConteudo(); }
            }
        );
        pp.addBotao(
            cancelar, true,
            new AoClicar() {
                public void acao() { recarregarConteudo(); }
            }
        );
        pp.mostrar(true);
    }

    public void setModelo(Elemento obj){
        if (obj != null){ 
            this.obj = obj;
            gerarConteudo(this.obj);
        }
    }

    private void recarregarConteudo(){
        setModelo(ServicosElemento.achar(this.obj.getId()));
    }

    private void apagar(){
        if (obj != null) ServicosElemento.apagar(this.obj.getId());
        this.obj = null;
        setVisible(false);
    }

    protected void gerarConteudo(Elemento obj){
        conteudoCard = new JPanel();
        JPanel leiaute = new JPanel();
        leiaute.setLayout(new BoxLayout(leiaute, BoxLayout.PAGE_AXIS));
        leiaute.setOpaque(false);
        leiaute.setAlignmentX(Component.LEFT_ALIGNMENT);
        leiaute.setAlignmentY(Component.TOP_ALIGNMENT);
        conteudoCard.add(leiaute);

        leiaute.add(Box.createRigidArea(new Dimension(150,5)));

        TagElementoArredondada painelElemento =  new TagElementoArredondada(obj);
        Dimension pref = painelElemento.getPreferredSize();
        painelElemento.setMaximumSize(pref);
        painelElemento.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelElemento.setAlignmentY(Component.TOP_ALIGNMENT);
        leiaute.add(painelElemento);
    }
    
}
