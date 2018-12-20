package ma.emi.rm.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ma.emi.rm.model.entities.Materiel;

public class GeneratePdfForDemande {
	
	public static ByteArrayInputStream pdfForDemande(Materiel materiel) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(materiel.getMaterielId());
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			Paragraph paragraph = new Paragraph();
		    paragraph.add(new Chunk("hello!"));
		    document.add(paragraph);
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}
