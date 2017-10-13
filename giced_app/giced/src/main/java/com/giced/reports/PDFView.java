package com.giced.reports;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.giced.model.AttendanceReport;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFView extends AbstractITextPdfView  {

	

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// get data model which is passed by the Spring container
        List<AttendanceReport> listReport = (List<AttendanceReport>) model.get("attReport");
		
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String today=dateFormat.format(date);
        
        doc.add(new Paragraph("Report : "+today));
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f, 1.0f, 1.0f, 1.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Assignment", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Course", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Subject", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Faculty", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Completed Duration", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Assigned Duration", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Pending Duration", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Completed", font));
        table.addCell(cell);
        
         
        // write table row data
        for (AttendanceReport ar : listReport) {
            table.addCell(ar.getAssignment_id());
            table.addCell(ar.getCourse());
            table.addCell(ar.getSubject());
            table.addCell(ar.getFaculty());
            table.addCell(ar.getCompleted_hours());
            table.addCell(ar.getAssigned_hours());
            table.addCell(ar.getPending_hours());
            table.addCell(ar.getIs_completed());         
        }
         
        doc.add(table);
	}

}
