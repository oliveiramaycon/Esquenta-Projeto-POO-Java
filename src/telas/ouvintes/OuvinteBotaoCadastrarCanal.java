package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.itextpdf.text.log.SysoCounter;

import modelo.canal.Canal;
import modelo.canal.CanalBroadcasting;
import modelo.canal.CanalDeTv;
import modelo.canal.enums.TipoCanal;
import modelo.canal.exceptions.CamposIncompletosException;
import modelo.exceptions.RegistroExistenteException;
import telas.TelaNovoCanal;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;
import utilidades.Validador;

public class OuvinteBotaoCadastrarCanal implements ActionListener {

	private TelaNovoCanal telaCanal;

	public OuvinteBotaoCadastrarCanal(TelaNovoCanal telaCanal) {
		this.telaCanal = telaCanal;
	}

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");

	@Override
	public void actionPerformed(ActionEvent e) {
		// String nomeCanal = telaCanal.getTfNome().getText();
		// TipoCanal tipoCanal = TipoCanal.valueOf(telaCanal.getTfTipo().getText());

		boolean validacao;
		try {
			validacao = Validador.validarPreenchimentoCanal(telaCanal);

			boolean isTv = true;
			Canal canal = null;

			if (telaCanal.getRb1().isSelected()) {
				canal = new CanalDeTv(telaCanal.getTfNome().getText(),
						TipoCanal.valueOf((String) telaCanal.getCbTv().getSelectedItem()),
						Integer.parseInt(telaCanal.getTfNumeroOuLink().getText()));
			} else {
				canal = new CanalBroadcasting(telaCanal.getTfNome().getText(),
						TipoCanal.valueOf((String) telaCanal.getCbBroadcasting().getSelectedItem()),
						telaCanal.getTfNumeroOuLink().getText());

			}
			central.adicionarCanal(canal);
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaCanal, "Canal cadastrado com sucesso!");
		} catch (CamposIncompletosException | NumberFormatException | RegistroExistenteException exception) {
			Componentes.msgFalha(telaCanal, exception.getMessage());
		}
	}

}
