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
import telas.canal.TelaCanal;
import telas.canal.TelaListagemCanais;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;
import utilidades.Validador;

public class OuvinteBotaoCadastrarCanal implements ActionListener {

	private TelaCanal telaCanal;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteBotaoCadastrarCanal(TelaCanal telaCanal) {
		this.telaCanal = telaCanal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			Validador.validarPreenchimentoCanal(telaCanal);

			String nome = telaCanal.getTfNome().getText();
			TipoCanal tipo = telaCanal.obterTipoSelecionado();
			String numeroOuLink = telaCanal.getTfNumeroOuLink().getText();

			// cadastro
			if (telaCanal.getCanal() == null) {
				Canal canal = null;

				if (telaCanal.getRb1().isSelected()) {
					canal = new CanalDeTv(nome, tipo, Integer.parseInt(numeroOuLink), telaCanal.getUsuarioLogado());
				} else {
					canal = new CanalBroadcasting(nome, tipo, numeroOuLink, telaCanal.getUsuarioLogado());
				}

				central.adicionarCanal(canal);
				persistencia.salvarCentral(central, "central");
				Componentes.msgSucesso(telaCanal, "Canal cadastrado com sucesso!");
				new TelaListagemCanais(telaCanal.getUsuarioLogado());
			} else { // edicao

				Canal canalSalvo = central.recuperarCanalPeloId(telaCanal.getCanal().getId());
				canalSalvo.setNome(nome);
				canalSalvo.setTipoCanal(tipo);
				canalSalvo.setDataDeAtualizacao(LocalDateTime.now());

				if (telaCanal.getRb1().isSelected()) {
					CanalDeTv canalDeTvSalvo = (CanalDeTv) canalSalvo;
					canalDeTvSalvo.setNumeroCanal(Integer.parseInt(numeroOuLink));
					canalSalvo = canalDeTvSalvo;
				} else {
					CanalBroadcasting canalBroadcastingSalvo = (CanalBroadcasting) canalSalvo;
					canalBroadcastingSalvo.setLink(numeroOuLink);
					canalSalvo = canalBroadcastingSalvo;
				}
				persistencia.salvarCentral(central, "central");
				Componentes.msgSucesso(telaCanal, "Canal editado com sucesso!");
				new TelaCanal(telaCanal.getUsuarioLogado(), canalSalvo, true);
			}

			telaCanal.dispose();

		} catch (CamposIncompletosException | NumberFormatException | RegistroExistenteException
				| RegistroNaoEncontradoException exception) {
			Componentes.msgFalha(telaCanal, exception.getMessage());
		}
	}

}
