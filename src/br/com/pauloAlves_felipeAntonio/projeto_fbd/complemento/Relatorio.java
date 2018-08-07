package br.com.pauloAlves_felipeAntonio.projeto_fbd.complemento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class Relatorio {

	public static void GerarLaudo(String caminho,String nomeLaudo,String texto,String cdM,String nomeM,String codP,String nomeP) throws FileNotFoundException, DocumentException{
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(caminho+"/"+nomeLaudo+".pdf"));
			document.open();
			document.add(new Paragraph("FBD CLÍNICAS",FontFactory.getFont(FontFactory.TIMES_BOLD,50)));
			//document.add(new Paragraph("________________________________________________________________________"));
			document.add(new Paragraph("Laudo",FontFactory.getFont(FontFactory.TIMES_BOLD,30)));
			document.add(new Paragraph("________________________________________________________________________"));
			document.add(new Paragraph("COD/MÉDICO",FontFactory.getFont(FontFactory.TIMES_BOLD,20)));
			document.add(new Paragraph(cdM+"-"+nomeM));
			document.add(new Paragraph("COD/PACIENTE",FontFactory.getFont(FontFactory.TIMES_BOLD,20)));
			document.add(new Paragraph(codP+"-"+nomeP));
			document.add(new Paragraph("________________________________________________________________________"));
			document.add(new Paragraph("DESCRIÇÃO",FontFactory.getFont(FontFactory.TIMES_BOLD,20)));
			document.add(new Paragraph(texto));
			document.add(new Paragraph("________________________________________________________________________"));
		    document.close();
	}
}
