package projetoFinal.ui.componentes.campos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import projetoFinal.ui.util.Imagens;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CampoImagem extends JPanel {

    private JLabel preview;
    private File arquivoImagem;
    private byte[] bytes;

    private static final int LARGURA = 120;
    private static final int ALTURA = 120;

    public CampoImagem(String labelTexto) {
        this.bytes = null;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);

        JLabel label = new JLabel(labelTexto);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(label);

        add(Box.createRigidArea(new Dimension(0, 6)));

        preview = new JLabel();
        preview.setPreferredSize(new Dimension(LARGURA, ALTURA));
        preview.setMaximumSize(new Dimension(LARGURA, ALTURA));
        preview.setMinimumSize(new Dimension(LARGURA, ALTURA));
        preview.setOpaque(false);
        //preview.setBackground(Color.WHITE);
        preview.setHorizontalAlignment(JLabel.CENTER);
        preview.setVerticalAlignment(JLabel.CENTER);
        preview.setCursor(new Cursor(Cursor.HAND_CURSOR));

        preview.setIcon(Imagens.iconeAnexarImagem(LARGURA, ALTURA));

        preview.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selecionarImagem();
            }
        });

        add(preview);
    }

    private void selecionarImagem() {
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter(
                "Imagens", "png", "jpg", "jpeg", "gif"
        ));

        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            arquivoImagem = chooser.getSelectedFile();
            atualizarPreview();
        }
        if (res == JFileChooser.CANCEL_OPTION || res == JFileChooser.ERROR_OPTION){
            this.limpar();
        }
    }

    private void atualizarPreview() {
        ImageIcon icon = new ImageIcon(arquivoImagem.getAbsolutePath());
        Image img = icon.getImage().getScaledInstance(
                LARGURA, ALTURA, Image.SCALE_SMOOTH
        );
        preview.setIcon(new ImageIcon(img));
    }

    public File getArquivoImagem() {
        return arquivoImagem;
    }

    public void setImagem(byte[] bytes){
        this.bytes = bytes;
        if (this.bytes != null) preview.setIcon(Imagens.escalaIcone(this.bytes, LARGURA, ALTURA));
        else limpar();
        
    }

    public byte[] getByteImagem() {
        File conteudo = getArquivoImagem();
        boolean temArquivo = true;
        if ((conteudo == null || !conteudo.exists() || !conteudo.isFile())) {
            temArquivo = false;
        }
        try {
            if (temArquivo) return Files.readAllBytes(conteudo.toPath());
            else return this.bytes;
        } catch (IOException e) {
            return null;
        }
    }

    public boolean temImagem() {
        return arquivoImagem != null || this.bytes != null;
    }
    public void limpar() {
        arquivoImagem = null;
        preview.setIcon(Imagens.iconeAnexarImagem(LARGURA, ALTURA));
    }
}

