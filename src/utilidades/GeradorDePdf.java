package utilidades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.Canal;
import modelo.ProgramaDeTv;

public class GeradorDePdf {

	public static void ObterProgramacaoDeUmCanal(Canal canal) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Document documento = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			PdfWriter.getInstance(documento, new FileOutputStream("relatorio.pdf"));

			documento.open();

			Paragraph p1 = new Paragraph("### Programas criados do canal " + canal + " ###\n");
			documento.add(p1);

			ArrayList<ProgramaDeTv> programas = central.buscarProgramasPorCanal(canal.getNome());

			if (programas.isEmpty()) {
				Paragraph p = new Paragraph("O canal " + canal.getNome() + "não possui programas");
				documento.add(p);
			} else {
				for (ProgramaDeTv programa : programas) {
					Paragraph p = new Paragraph(programa.toString());
					documento.add(p);
				}
			}
			documento.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
