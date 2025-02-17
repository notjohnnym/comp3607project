package comp3607project.tool;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import comp3607project.grade.TestResult;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;

import java.util.ArrayList;

public class PDFGenerator {
    private static Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
    private static Font headerFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
    private static Font cellFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, BaseColor.BLACK);
    
    public static void generate(String filePath, ArrayList<TestResult> summary, String folderName, int grade) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(new File(filePath, "results.pdf")));
            document.open();
            addMetaData(document);
            addContent(document, summary, folderName, grade);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addContent(Document document, ArrayList<TestResult> summary, String folderName, int grade) throws DocumentException {
        document.add(new Paragraph(("Student Info: "+ folderName + "\nGrade: " + grade + "/100"), defaultFont));
        document.add(new Paragraph(" "));
        
        PdfPTable table = new PdfPTable(3); 
        table.setWidthPercentage(100);     
        
        PdfPCell headerCell1 = new PdfPCell(new Paragraph("Description", headerFont));
        headerCell1.setBackgroundColor(BaseColor.PINK); // Set background color for header
        headerCell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); // Center align the header
        table.addCell(headerCell1);

        PdfPCell headerCell2 = new PdfPCell(new Paragraph("Status", headerFont));
        headerCell2.setBackgroundColor(BaseColor.PINK);
        headerCell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(headerCell2);

        PdfPCell headerCell3 = new PdfPCell(new Paragraph("Mark", headerFont));
        headerCell3.setBackgroundColor(BaseColor.PINK);
        headerCell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(headerCell3);

        if (summary.isEmpty()) {
            document.add(new Paragraph("This submission has invalid files", defaultFont));
        } else {
            for (TestResult result : summary) {
                PdfPCell nameCell = new PdfPCell(new Paragraph(result.getDescription(), cellFont));
                nameCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(nameCell);

                PdfPCell scoreCell = new PdfPCell(new Paragraph(String.valueOf(result.getStatus()), cellFont));
                scoreCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); 
                table.addCell(scoreCell);

                PdfPCell commentsCell = new PdfPCell(new Paragraph(String.valueOf(result.getMark()), cellFont));
                commentsCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER); 
                table.addCell(commentsCell);
            }
        }

        document.add(table); // Add the table to the document
    }

    private static void addMetaData(Document document) {
        document.addTitle("COMP 2603 A1 Results");
        document.addSubject("");
        document.addKeywords("Java, OOP1, COMP2603, A1");
        document.addAuthor("Overly-Optimistic Procrastinators II");
        document.addCreator("Overly-Optimistic Procrastinators II");
    }
}

/*
 * References: 
 * 
 * - https://www.vogella.com/tutorials/JavaPDF/article.html
 * 
 */
