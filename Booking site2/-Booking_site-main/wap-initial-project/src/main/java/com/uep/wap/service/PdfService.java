package com.uep.wap.service;

import com.uep.wap.model.Booking;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {
    public byte[] generateInvoice(Booking booking) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("Invoice"));
            document.add(new Paragraph("Name: " + booking.getUser().getName()));
            document.add(new Paragraph("Email: " + booking.getUser().getEmail()));
            document.add(new Paragraph("Accommodation: " + booking.getAccommodation().getName() + ", " +
                    booking.getAccommodation().getAddress() + ", " +
                    booking.getAccommodation().getCity() + ", " +
                    booking.getAccommodation().getCountry()));
            document.add(new Paragraph("Check In Date: " + booking.getCheckInDate()));
            document.add(new Paragraph("Check Out Date: " + booking.getCheckOutDate()));
            document.add(new Paragraph("Total Price: " + booking.getTotalPrice()));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}
