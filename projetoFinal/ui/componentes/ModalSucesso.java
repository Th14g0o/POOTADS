package projetoFinal.ui.componentes;

import javax.swing.JOptionPane;

public class ModalSucesso extends JOptionPane {
    public static void ExibirModal(String texto){
        showMessageDialog(
            null,
            texto,
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
