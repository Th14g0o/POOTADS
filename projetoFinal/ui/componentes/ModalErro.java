package projetoFinal.ui.componentes;

import javax.swing.JOptionPane;

public class ModalErro extends JOptionPane {
    public static void ExibirModal(String texto){
        showMessageDialog(
            null,
            texto,
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
