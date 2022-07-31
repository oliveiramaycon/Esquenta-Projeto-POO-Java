package utilidades;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modelo.canal.Canal;
import modelo.canal.CanalBroadcasting;
import modelo.canal.CanalDeTv;
import modelo.programa.ProgramaDeTv;
import modelo.programa.ProgramasContinuos;
import modelo.programa.SeriesRegulares;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.TipoPrograma;
import modelo.programa.exceptions.ProgramaNaoFavoritado;
import modelo.usuario.Usuario;
import telas.ouvintes.OuvinteHandCursor;
import telas.ouvintes.OuvinteMenu;
import telas.programa.TelaListagemProgramas;
import telas.programa.TelaNovoPrograma;

public class Componentes {

	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return botao
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JButton addJButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JButton botao = new JButton(nome);
		botao.setBounds(x, y, comprimento, altura);
		tela.add(botao);
		return botao;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param texto
	 * representa a mensagem exibida ao passar o mouse sobre o componente
	 * 
	 * @param icone
	 * representa uma imagem associada ao componente
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return botao
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JButton addJButton(JFrame tela, String texto, ImageIcon icone, int x, int y, int comprimento,
			int altura) {
		JButton botao = new JButton();
		botao.setToolTipText(texto);
		botao.setIcon(icone);
		botao.setBounds(x, y, comprimento, altura);
		OuvinteHandCursor cursorHand = new OuvinteHandCursor(botao);
		botao.addMouseListener(cursorHand);
		tela.add(botao);
		return botao;
	}
	/**
	 * @param painel
	 *representa a area onde estarao presentes um conjunto de botoes
	 * 
	 * @param texto
	 * representa a mensagem exibida ao passar o mouse sobre o componente
	 * 
	 * @param icone
	 * representa uma imagem associada ao componente
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return botao
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JButton adicionarJButton(JPanel painel, String texto, ImageIcon icone, int x, int y, int comprimento,
			int altura) {
		JButton botao = new JButton();
		botao.setToolTipText(texto);
		botao.setIcon(icone);
		botao.setVerticalTextPosition(SwingConstants.BOTTOM);
		botao.setHorizontalTextPosition(SwingConstants.CENTER);
		botao.setBorder(null);
		botao.setBounds(x, y, comprimento, altura);
		painel.add(botao);

		OuvinteHandCursor cursorHand = new OuvinteHandCursor(botao);
		botao.addMouseListener(cursorHand);
		return botao;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param nome
	 * representa o nome exibido ao lado do componente
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return checkBox
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JCheckBox addCheckBox(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JCheckBox checkBox = new JCheckBox(nome);
		checkBox.setBounds(x, y, comprimento, altura);
		tela.add(checkBox);

		return checkBox;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param nome
	 * representa o nome do componente exibido na tela
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return label
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static OutlineJLabel addJLabel(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		OutlineJLabel label = new OutlineJLabel(nome);
		label.setBounds(x, y, comprimento, altura);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		tela.add(label);
		return label;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return field
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JTextField addJTextField(JFrame tela, int x, int y, int comprimento, int altura) {
		JTextField field = new JTextField();
		field.setBounds(x, y, comprimento, altura);
		tela.add(field);
		return field;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 *@param icone
	 *representa uma imagem associada ao componente
	 *
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return field
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JTextField addJTextFieldComIcone(JFrame tela, ImageIcon icone, int x, int y, int comprimento,
			int altura) {
		IconJTextField field = new IconJTextField();
		field.setIcon(icone);
		field.setBounds(x, y, comprimento, altura);
		tela.add(field);
		return field;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return paswordField
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JPasswordField addJPswordField(JFrame tela, int x, int y, int comprimento, int altura) {
		JPasswordField paswordField = new JPasswordField();
		paswordField.setBounds(x, y, comprimento, altura);
		tela.add(paswordField);
		return paswordField;
	}
	/**
	 * @param janela
	 *JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return barraMenu
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JMenuBar addJMenubar(JFrame janela, int x, int y, int comprimento, int altura) {
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(x, y, comprimento, altura);
		barraMenu.setBackground(Color.BLACK);
		barraMenu.setForeground(Color.black);
		janela.add(barraMenu);
		return barraMenu;
	}
	/**
	 * @param janela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @return barraMenu
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JMenuBar addMenuPadrao(JFrame janela) {
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(838, 0, 45, 30);
		barraMenu.setBackground(Color.BLACK);
		barraMenu.setForeground(Color.black);

		JMenu menu = addJMenuComIcone(barraMenu, Icones.ENGRENAGEM);
		menu.setToolTipText("opcoes");

		OuvinteMenu ouvinteMenu = new OuvinteMenu(janela);

		JMenuItem sair = addItemNoMenu(menu, "Sair");
		sair.addActionListener(ouvinteMenu);

		JMenuItem deletar = addItemNoMenu(menu, "Excluir Conta");
		deletar.addActionListener(ouvinteMenu);

		JMenuItem editarUsuario = addItemNoMenu(menu, "Editar Perfil");
		editarUsuario.addActionListener(ouvinteMenu);

		janela.add(barraMenu);
		return barraMenu;
	}
	/**
	 * @param barraDeMenu
	 * representa a barra onde ficara o menu
	 *  
	 * @param icone
	 * representa uma imagem associada ao componente
	 * 
	 * @return menu
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JMenu addJMenuComIcone(JMenuBar barraDeMenu, ImageIcon icone) {
		JMenu menu = new JMenu();
		menu.setIcon(icone);
		barraDeMenu.add(menu);
		return menu;
	}
	/**
	 * @param menu
	 * representa o locao onde ficarao os itens especificos
	 *  
	 * @param nome
	 * representa o nome dos itens dentro do menu
	 * 
	 * @return item
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JMenuItem addItemNoMenu(JMenu menu, String nome) {
		JMenuItem item = new JMenuItem(nome);
		menu.add(item);
		return item;

	}
	/**
	 * @param janela
	 * JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param msg
	 * representa o texto exibido no componente
	 * 
	 * 
	 */	
	public static void msgFalha(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * @param janela
	 * JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param msg
	 * representa o texto exibido no componente
	 * 
	 * 
	 */	
	public static void msgSucesso(JFrame janela, String msg) {
		JOptionPane.showMessageDialog(janela, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * @param janela
	 * JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param msg
	 * representa o texto exibido no componente
	 * 
	 * @param titulo
	 * representa o titulo com componente exibido
	 * 
	 * @return 
	 * retorna um valor inteiro indicando a opcao escolhida pelo usuario
	 */	
	public static int showConfirmDialog(JFrame janela, String msg, String titulo) {
		return JOptionPane.showConfirmDialog(janela, msg, titulo, JOptionPane.YES_NO_OPTION);
	}
	/**
	 * @param tela
	 * JFrame que representa a tela onde o componente sera exibido
	 *  
	 * @param dados
	 * valores exibidos no componente
	 * 
	 * * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return cbTipos
	 * representa o componente adicionado na tela
	 */	
	public static JComboBox<String> inserirComboBox(JFrame tela, ArrayList<String> dados, int x, int y, int comprimento,
			int altura) {

		Vector<String> tiposDeProgramas = new Vector<String>(dados);

		JComboBox<String> cbTipos = new JComboBox<String>(tiposDeProgramas);
		cbTipos.setBounds(x, y, comprimento, altura);
		tela.add(cbTipos);
		return cbTipos;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param nome
	 * representa o nome exibido ao lado do componente
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return radioBotao
	 * representa o componente adicionado na tela
	 * 
	 */	
	public static JRadioButton addRadioButton(JFrame tela, String nome, int x, int y, int comprimento, int altura) {
		JRadioButton radioBotao = new JRadioButton(nome);
		radioBotao.setBounds(x, y, comprimento, altura);
		tela.add(radioBotao);
		return radioBotao;
	}
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param usuarioLogado
	 * representa a referencia para o usuario logado
	 * 
	 * @param tfPesquisa
	 * representa o campo onde devem-se fazer as buscas/pesquisas
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return tabela
	 * representa o componente adicionado na tela
	 * 
	 */	
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
			modelo.addColumn("Nao ha canais cadastrados!");
		} else {
			modelo.addColumn("ID");
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo");
			modelo.addColumn("Link ou Numero");
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
	/**
	 * @param tela
	 *JFrame que representa a tela onde o componente sera exibido
	 * 
	 * @param usuarioLogado
	 * representa a referencia para o usuario logado
	 * 
	 * @param tfPesquisa
	 * representa o campo onde devem-se fazer as buscas/pesquisas
	 * 
	 * @param x
	 * representa a coordenada no eixo x
	 * 
	 * @param y
	 * representa a coordenada no eixo y
	 * 
	 * @param comprimento
	 * representa a dimensao de comprimento do componente
	 * 
	 * @param altura
	 * representa a dimensao de altura do componente
	 * 
	 * @return tabela
	 * representa o componente adicionado na tela
	 * 
	 */	
}
