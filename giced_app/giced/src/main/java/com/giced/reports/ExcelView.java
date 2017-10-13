package com.giced.reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.giced.model.AttendanceReport;


public class ExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// change the file name
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String today=dateFormat.format(date);
	    response.setHeader("Content-Disposition", "attachment; filename=\"Report_"+today+".xls\"");

	    @SuppressWarnings("unchecked")
	    List<AttendanceReport> listReport = (List<AttendanceReport>) model.get("attReport");

	    // create excel xls sheet
	    Sheet sheet = workbook.createSheet("User Detail");
	    sheet.setDefaultColumnWidth(30);

	    // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);


	    // create header row
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Assignment");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("Course");
	    header.getCell(1).setCellStyle(style);
	    header.createCell(2).setCellValue("Subject");
	    header.getCell(2).setCellStyle(style);
	    header.createCell(3).setCellValue("Faculty");
	    header.getCell(3).setCellStyle(style);
	    header.createCell(4).setCellValue("Completed Duration");
	    header.getCell(4).setCellStyle(style);
	    header.createCell(5).setCellValue("Assigned Duration");
	    header.getCell(5).setCellStyle(style);
	    header.createCell(6).setCellValue("Pending Duration");
	    header.getCell(6).setCellStyle(style);
	    header.createCell(7).setCellValue("Completed");
	    header.getCell(7).setCellStyle(style);

	    int rowCount = 1;
      

	    for (AttendanceReport ar : listReport) {
	        Row userRow =  sheet.createRow(rowCount++);
	        userRow.createCell(0).setCellValue(ar.getAssignment_id());
	        userRow.createCell(1).setCellValue(ar.getCourse());
	        userRow.createCell(2).setCellValue(ar.getSubject());
	        userRow.createCell(3).setCellValue(ar.getFaculty());
	        userRow.createCell(4).setCellValue(ar.getCompleted_hours());
	        userRow.createCell(5).setCellValue(ar.getAssigned_hours());
	        userRow.createCell(6).setCellValue(ar.getPending_hours());
	        userRow.createCell(7).setCellValue(ar.getIs_completed());
	        }
		
	}

}
