package utilidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.canal.Canal;
import modelo.programa.ProgramaDeTv;

public class GeradorDePdf {

	public static void ObterProgramacaoDeUmCanal(Canal canal) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Document documento = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			PdfWriter.getInstance(documento, new FileOutputStream("relatorio.pdf"));

			documento.open();
			PdfPTable tabela = new PdfPTable(2);
			Paragraph p1 = new Paragraph("### Programas criados do canal " + canal + " ###\n");
			Paragraph separador = new Paragraph("                                     ");
			documento.add(p1);

			ArrayList<ProgramaDeTv> programas = central.buscarProgramasPorCanal(canal.getNome());

			if (programas.isEmpty()) {
				Paragraph p = new Paragraph("O canal " + canal.getNome() + "nao possui programas");
				documento.add(p);

			} else {
				tabela.addCell("Programas");
				tabela.addCell("Horarios");
				for (ProgramaDeTv programa : programas) {
					tabela.addCell(programa.getNome());
					tabela.addCell(programa.getHorario());

				}
				documento.add(tabela);
			}
			documento.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
