package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.canal.Canal;
import modelo.exceptions.FalhaNoCadastroException;
import modelo.exceptions.RegistroNaoEncontradoException;
import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.TipoPrograma;
import telas.TelaNovoPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoCadastrarPrograma implements ActionListener{

	private TelaNovoPrograma telaPrograma;
	
	public OuvinteBotaoCadastrarPrograma(TelaNovoPrograma telaPrograma) {
		this.telaPrograma = telaPrograma;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String nome = telaPrograma.getTfNome().getText();
		String tipo = (String) telaPrograma.getTfTipo().getSelectedItem();
		String canalDeTransmissao = telaPrograma.getTfCanalDeTransmissao().getText();
		String diasDeTransmissao = telaPrograma.getTfdiasDeTransmissao().getText();
		TipoPrograma tipoEnum = TipoPrograma.valueOf(tipo);
		Canal canal = null;
		try {
			canal = central.recuperarCanalPeloNome(canalDeTransmissao);
			
		}  catch (RegistroNaoEncontradoException exception) {
			System.out.println(exception.getMessage());
		}
		
		String[] dias = diasDeTransmissao.split(",");
		ArrayList<String> diasDaSemana = new ArrayList<>(Arrays.asList(dias));
		
		//TODO: MUDAR DIASDASEMANA PARA O TIPO DAYOFWEEK
		//ProgramaDeTv programa = new ProgramaDeTv(nome, tipoEnum, canal, diasDaSemana);
		
//		try {
//			central.AdicionarProgramaDeTv(programa);
//			persistencia.salvarCentral(central, "central");
//			Componentes.msgSucesso(telaPrograma, "Canal cadastrado com sucesso!");
//		} catch (FalhaNoCadastroException exception) {
//			//System.out.println(exception.getMessage());
//			Componentes.msgFalha(telaPrograma, exception.getMessage());
//		}
	}

}
