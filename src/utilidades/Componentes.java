package utilidades;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.thoughtworks.xstream.converters.basic.DateConverter;

import modelo.canal.Canal;
import modelo.canal.CanalBroadcasting;
import modelo.canal.CanalDeTv;
import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.RealityShows;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.Estilo;
import modelo.programa.enums.TipoPrograma;
import modelo.usuario.Usuario;
import telas.programa.TelaNovoPrograma;

public class Componentes {

	public static JButton addJButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JButton botao = new JButton(nome);
		botao.setBounds(x, y, comprimento, altura);
		tela.add(botao);
		return botao;
	}

	public static JButton addJButton(JFrame tela, String nome, ImageIcon icone, int x, int y, int comprimento,
			int altura) {
		JButton botao = new JButton(nome);
		botao.setIcon(icone);
		botao.setBounds(x, y, comprimento, altura);
		tela.add(botao);
		return botao;
	}
	public static JCheckBox addCheckBox(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JCheckBox checkBox = new JCheckBox(nome);
		checkBox.setBounds(x,y,comprimento,altura);
		tela.add(checkBox);
	
		return checkBox;
	}

	public static OutlineJLabel addJLabel(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		OutlineJLabel label = new OutlineJLabel(nome);
		label.setBounds(x, y, comprimento, altura);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		tela.add(label);
		return label;
	}

	public static JTextField addJTextField(JFrame tela, int x, int y, int comprimento, int altura) {
		JTextField field = new JTextField();
		field.setBounds(x, y, comprimento, altura);
		tela.add(field);
		return field;
	}

	public static JTextField addJTextFieldComIcone(JFrame tela, ImageIcon icone, int x, int y, int comprimento,
			int altura) {
		IconJTextField field = new IconJTextField();
		field.setIcon(icone);
		field.setBounds(x, y, comprimento, altura);
		tela.add(field);
		return field;
	}

	public static JMenuBar addJMenubar(JFrame janela, int x, int y, int comprimento, int altura) {
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(x, y, comprimento, altura);
		barraMenu.setBackground(Color.BLACK);
		barraMenu.setForeground(Color.black);
		janela.add(barraMenu);
		return barraMenu;
	}

	public static JMenu addJMenuComIcone(JMenuBar barraDeMenu, ImageIcon icone) {
		JMenu menu = new JMenu();
		menu.setIcon(icone);
		barraDeMenu.add(menu);
		return menu;
	}

	public static JMenuItem addItemNoMenu(JMenu menu, String nome) {
		JMenuItem item = new JMenuItem(nome);
		menu.add(item);
		return item;

	}

	public static void msgFalha(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public static void msgSucesso(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Sucesso", JOptionPane.OK_OPTION, Icones.ENGRENAGEM); //// mudar
																											//// icone(setinha)
	}

	public static int showConfirmDialog(JFrame janela, String msg, String titulo) {
		return JOptionPane.showConfirmDialog(janela, msg, titulo, JOptionPane.YES_NO_OPTION);
	}

	public static JComboBox<String> inserirComboBox(JFrame tela, ArrayList<String> dados, int x, int y, int comprimento,
			int altura) {

		Vector<String> tiposDeProgramas = new Vector<String>(dados);

		JComboBox<String> cbTipos = new JComboBox<String>(tiposDeProgramas);
		cbTipos.setBounds(x, y, comprimento, altura);
		tela.add(cbTipos);
		return cbTipos;
	}

	public static JRadioButton addRadioButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JRadioButton radioBotao = new JRadioButton(nome);
		radioBotao.setBounds(x, y, comprimento, altura);
		tela.add(radioBotao);
		return radioBotao;
	}

	public static JTable addTabelaTodosCanais(JFrame tela, Usuario usuarioLogado, JTextField tfPesquisa, int x, int y,
			int comprimento, int altura) {
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable tabela = new JTable(modelo);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabela.getModel());
		tabela.setRowSorter(rowSorter);

		tfPesquisa.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfPesquisa.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfPesquisa.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		});

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		ArrayList<Canal> canais = central.getCanais();

		if (canais.size() == 0) {
			modelo.addColumn("N�o h� canais cadastrados!");
		} else {
			modelo.addColumn("ID");
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo");
			modelo.addColumn("Link ou N�mero");
			modelo.addColumn("Programas");
			modelo.addColumn("Favoritos");
			modelo.addColumn("Data de Cadastro");

//			escondendo a coluna ID 
			tabela.getColumnModel().getColumn(0).setMinWidth(0);
			tabela.getColumnModel().getColumn(0).setMaxWidth(0);

			Object[] linhas = new Object[canais.size()];

			for (Canal canal : canais) {
				Object[] linha = new Object[7];

				String linkOuNumero = null;
				if (canal instanceof CanalDeTv) {
					linkOuNumero = String.valueOf(((CanalDeTv) canal).getNumeroCanal());
				} else if (canal instanceof CanalBroadcasting) {
					linkOuNumero = ((CanalBroadcasting) canal).getLink();

				}

				linha[0] = canal.getId();
				linha[1] = canal.getNome();
				linha[2] = canal.getTipoCanal();
				linha[3] = linkOuNumero;
				linha[4] = canal.getProgramas().size();
				linha[5] = usuarioLogado.obterQuantidadeDeProgramasFavoritos(canal.getProgramas());

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				linha[6] = sdf.format(Date.from(canal.getDataDeCadastro().atZone(ZoneId.systemDefault()).toInstant()));

				modelo.addRow(linha);
			}
			tabela.addRowSelectionInterval(0, 0);
		}

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(x, y, comprimento, altura);
		tela.add(scroll);
		return tabela;
	}

	public static JTable addTabelaTodosProgramas(JFrame tela, Usuario usuarioLogado, JTextField tfPesquisa, int x,
			int y, int comprimento, int altura) {
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable tabela = new JTable(modelo);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabela.getModel());
		tabela.setRowSorter(rowSorter);

		tfPesquisa.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfPesquisa.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfPesquisa.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet.");
			}

		});

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		ArrayList<ProgramaDeTv> programas = central.getProgramas();

		if (programas.size() == 0) {
			modelo.addColumn("Nao ha programas cadastrados!");
		} else {
			modelo.addColumn("ID");
			modelo.addColumn("Nome");
			modelo.addColumn("Canal");
			modelo.addColumn("Preferencia");
			modelo.addColumn("Genero ou Apresentadores");
			modelo.addColumn("Estilo");
			modelo.addColumn("Horario");
			modelo.addColumn("Temporadas");
			modelo.addColumn("Status do Programa");

//				escondendo a coluna ID 
			tabela.getColumnModel().getColumn(0).setMinWidth(0);
			tabela.getColumnModel().getColumn(0).setMaxWidth(0);

			Object[] linhas = new Object[programas.size()];

			for (ProgramaDeTv programa : programas) {
				Object[] linha = new Object[9];

				String estilo = null;
				String generoouApresentadores = null;
				String preferencia = String.valueOf(programa.getFavorito());
				if (programa.getTipo() == TipoPrograma.SERIES_REGULARES) {
					SeriesRegulares programaModificado = (SeriesRegulares) programa;
					generoouApresentadores = String.valueOf(programaModificado.getGenero());
					estilo = (String.valueOf(programaModificado.getEstilo()));
				} else {
					ProgramasContinuos programaModificado = (ProgramasContinuos) programa;
						
					String apresentadores = "";
					for(String concatenar:programaModificado.getApresentadores()) {
						apresentadores +=  concatenar+",";
					}
					
					generoouApresentadores = apresentadores;
				}

				linha[0] = programa.getId();
				linha[1] = programa.getNome();
				linha[2] = programa.getCanal().toString();
				linha[3] = preferencia;
				linha[4] = generoouApresentadores;
				linha[5] = estilo;
				linha[6] = programa.getHorario();
				linha[7] = programa.getTemporadas();
				linha[8] = programa.getStatus();

				modelo.addRow(linha);
			}
			tabela.addRowSelectionInterval(0, 0);
		}

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(x, y, comprimento, altura);
		tela.add(scroll);
		return tabela;
	}

	public static ArrayList<String> passandoArrayCanalParaString(ArrayList<Canal> array) {
		ArrayList<String> ArrayConvertida = new ArrayList<>();

		for(Canal c : array) {
			ArrayConvertida.add(c.getNome());

		}
		return ArrayConvertida;
	}
	
	public static void testandoData(TelaNovoPrograma tela) {
		String dataTxt = tela.getDataRetorno().getText();
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		try {
			d = mascara.parse(dataTxt);
		} catch (ParseException e) {}
		Date dia = new Date();
		String[] dataSeparada = dataTxt.split("/");
		int diaData =Integer.parseInt( dataSeparada[0]);
		int mes = Integer.parseInt(dataSeparada[1]);
		String msgErro = "Data inválida";
		if(diaData > 31)
			msgFalha(tela, msgErro);
		else if(diaData > 29 && mes == 2 )
			msgFalha(tela, msgErro);
		if(dia.after(d)) {
			msgFalha(tela, msgErro);
		
		}	
	}
}
