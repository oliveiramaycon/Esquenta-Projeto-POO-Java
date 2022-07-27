package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import modelo.canal.Canal;
import modelo.canal.CanalBroadcasting;
import modelo.canal.CanalDeTv;
import modelo.canal.enums.TipoCanal;
import modelo.canal.exceptions.CamposIncompletosException;
import modelo.exceptions.RegistroExistenteException;
import modelo.exceptions.RegistroNaoEncontradoException;
import telas.canal.TelaDetalheCanal;
import telas.canal.TelaListagemCanais;
import telas.canal.TelaNovoCanal;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;
import utilidades.Validador;

public class OuvinteBotaoCadastrarCanal implements ActionListener {

	private TelaNovoCanal telaCanal;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteBotaoCadastrarCanal(TelaNovoCanal telaCanal) {
		this.telaCanal = telaCanal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// String nomeCanal = telaCanal.getTfNome().getText();
		// TipoCanal tipoCanal = TipoCanal.valueOf(telaCanal.getTfTipo().getText());

		try {
			Validador.validarPreenchimentoCanal(telaCanal);

			// obter valores dos campos da tela

			String nome = telaCanal.getTfNome().getText();
			TipoCanal tipo = telaCanal.obterTipoSelecionado();
			String numeroOuLink = telaCanal.getTfNumeroOuLink().getText();

			if (telaCanal.getCanal() == null) {
				Canal canal = null;

				if (telaCanal.getRb1().isSelected()) {
					canal = new CanalDeTv(nome, tipo, Integer.parseInt(numeroOuLink), telaCanal.getUsuarioLogado());
				} else {
					canal = new CanalBroadcasting(nome, tipo, numeroOuLink, telaCanal.getUsuarioLogado());
				}

				central.adicionarCanal(canal);
				Componentes.msgSucesso(telaCanal, "Canal cadastrado com sucesso!");
				new TelaListagemCanais(telaCanal.getUsuarioLogado());
			} else {

				Canal canalSalvo = central.recuperarCanalPeloId(telaCanal.getCanal().getId());
				canalSalvo.setNome(nome);
				canalSalvo.setTipoCanal(tipo);
				canalSalvo.setDataDeAtualizacao(LocalDateTime.now());

				if (telaCanal.getRb1().isSelected()) {
					// numero
					CanalDeTv canalDeTvSalvo = (CanalDeTv) canalSalvo;

					canalDeTvSalvo.setNumeroCanal(Integer.parseInt(numeroOuLink));

					canalSalvo = canalDeTvSalvo;
				} else {
					// link
					CanalBroadcasting canalBroadcastingSalvo = (CanalBroadcasting) canalSalvo;

					canalBroadcastingSalvo.setLink(numeroOuLink);

					canalSalvo = canalBroadcastingSalvo;
				}
				Componentes.msgSucesso(telaCanal, "Canal editado com sucesso!");
				new TelaDetalheCanal(telaCanal.getUsuarioLogado(), canalSalvo);
			}
			persistencia.salvarCentral(central, "central");
			telaCanal.dispose();

		} catch (CamposIncompletosException | NumberFormatException | RegistroExistenteException
				| RegistroNaoEncontradoException exception) {
			Componentes.msgFalha(telaCanal, exception.getMessage());
		}
	}

}
