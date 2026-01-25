package aulas_lucena.projetoFinal.ui.telas.tabs;

import java.awt.*;
import javax.swing.*;

import aulas_lucena.projetoFinal.ui.util.Cores;

public class CadastroVantagem extends JPanel{
    public CadastroVantagem() {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Fundo
        JPanel fundo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        fundo.setBackground(Cores.VERMELHO);
        add(fundo, BorderLayout.CENTER);

        // Organização do form em grid
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        fundo.add(formulario);

        // criação do grid
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.WHITE);
        formulario.add(lblNome, gbc);

        // input
        gbc.gridx = 0;
        gbc.gridy = 1;
        JTextField txtNome = new JTextField(20);
        formulario.add(txtNome, gbc);
        

        // Scroll
        //JScrollPane scroll = new JScrollPane(formulario);
        //scroll.setBorder(null);
        //scroll.getViewport().setOpaque(false);
        //scroll.setOpaque(false);

        //add(scroll, BorderLayout.CENTER);
    }
}
