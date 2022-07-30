package utilidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.EnumFavorito;
import modelo.usuario.Usuario;

public class GeradorDePdf {

	public static void ObterProgramacao() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		Usuario usuario = central.getUsuariosCadastrados().get(0);
		String nome = usuario.getNome();

		Document documento = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			PdfWriter.getInstance(documento, new FileOutputStream("relatorio.pdf"));

			documento.open();
			PdfPTable tabela = new PdfPTable(3);
			Paragraph p1 = new Paragraph("### Programas da semana do Usuario " + nome + " ###");
			Paragraph separador = new Paragraph("                                                  ");
			documento.add(p1);
			documento.add(separador);
			ArrayList<ProgramaDeTv> programas = central.getProgramas();

			if (programas.isEmpty()) {
				Paragraph p = new Paragraph("O usuario: " + nome + " nao possui programas da semana.");
				documento.add(p);

			} else {
				tabela.addCell("Programas");
				tabela.addCell("Dia da semana");
				tabela.addCell("Horarios");
				ArrayList<String> dias = null;
				for (ProgramaDeTv programa : programas) {
					dias = central.mudarDiaDaSemana(programa.getDiasDaSemana());
					if (programa.getDiasDaSemana().size() > 1) {
						for (int c = 0; programa.getDiasDaSemana().size() > c; c++) {
							tabela.addCell(programa.getNome());
							tabela.addCell(dias.get(c));
							tabela.addCell(programa.getHorario());
						}
					} else {
						tabela.addCell(programa.getNome());
						tabela.addCell(dias.get(0));
						tabela.addCell(programa.getHorario());
					}

				}
				documento.add(tabela);
			}
			documento.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void SeriesFavoritas() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		Usuario usuario = central.getUsuariosCadastrados().get(0);
		String nome = usuario.getNome();

		Document documento = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			PdfWriter.getInstance(documento, new FileOutputStream("relacaofavoritos.pdf"));

			documento.open();
			PdfPTable tabela = new PdfPTable(3);
			Paragraph p1 = new Paragraph("### Programas favoritos do Usuario " + nome + " ###");
			Paragraph separador = new Paragraph("                                                  ");
			documento.add(p1);
			documento.add(separador);
			ArrayList<ProgramaDeTv> programas = central.getProgramas();
			ArrayList<ProgramaDeTv> programasFavoritos = new ArrayList<>();
			for (ProgramaDeTv programa : programas) {
				if (programa.getFavorito() == EnumFavorito.FAVORITO)
					programasFavoritos.add(programa);
			}

			if (!programasFavoritos.isEmpty()) {
				tabela.addCell("Programas");
				tabela.addCell("Dia da semana");
				tabela.addCell("Horarios");
				ArrayList<String> dias = null;
				for (ProgramaDeTv programa : programas) {
					boolean checandoPrograma = programa.getFavorito() == EnumFavorito.FAVORITO;
					dias = central.mudarDiaDaSemana(programa.getDiasDaSemana());
					if (programa.getDiasDaSemana().size() > 1 && checandoPrograma) {
						for (int c = 0; programa.getDiasDaSemana().size() > c; c++) {
							tabela.addCell(programa.getNome());
							tabela.addCell(dias.get(c));
							tabela.addCell(programa.getHorario());
						}
					} else if (programa.getDiasDaSemana().size() == 0 && checandoPrograma) {
						tabela.addCell(programa.getNome());
						tabela.addCell(dias.get(0));
						tabela.addCell(programa.getHorario());
					}

				}
				documento.add(tabela);
			} else {
				Paragraph p3 = new Paragraph("O usuario " + usuario.getNome() + " Não tem programas favoritos");
				documento.add(p3);
			}
			documento.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
