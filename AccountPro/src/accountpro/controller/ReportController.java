package accountpro.controller;

import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Customer;
import accountpro.service.ReportService;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class ReportController {

	private ReportService reportService;
	
	private static final Logger logger = Logger.getLogger(ReportController.class.getName());

	@RequestMapping(value="/report.htm")	
	public ModelAndView getReport(){
	    ModelAndView mav = new ModelAndView();
	    
	    List<Customer> customers = reportService.getReport();
	    logger.info("generating reports..");
	    createReport(customers);
	    logger.info("done with reports.");
	    
	    mav.setViewName("Report");
	    return mav;
	}

	private void createReport(List<Customer> customers){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("PolicyReport.pdf"));
            document.open();
            document.add(new Paragraph("AccountPro Report"));
            //document.add(new Chunk("some chunk"));
            
            PdfPTable table = new PdfPTable(3); // 3 columns.

            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            for(Customer customer:customers){
                PdfPCell cell1 = new PdfPCell(new Paragraph(customer.getFirstName()+customer.getLastName()));
                PdfPCell cell2 = new PdfPCell(new Paragraph(customer.getAddress()));
                PdfPCell cell3 = new PdfPCell(new Paragraph(customer.getCity()));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
            }

            document.add(table);
            
            document.close();
        }
        catch (Exception i)
        {
            System.out.println(i);
        }

	}
	
	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}


}
