package com.lifetech.util;


import com.itextpdf.text.pdf.PdfWriter;
import com.lifetech.domain.dao.ExtraCostDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.model.ExtraCost;

import com.lifetech.domain.model.Person;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class PDFGenerator {

    private final ExtraCostDAO extraCostDAO;
    private final PersonDAO personDAO;
    private final SubscriptionDAO subscriptionDAO;
    private static Logger LOG = LoggerFactory.getLogger(PDFGenerator.class);

    public PDFGenerator(ExtraCostDAO extraCostDAO, PersonDAO personDAO, SubscriptionDAO subscriptionDAO) {
        this.extraCostDAO = extraCostDAO;
        this.personDAO = personDAO;
        this.subscriptionDAO = subscriptionDAO;

    }

    public ByteArrayInputStream billingPDFReport(@Valid String login) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph( "Subscription'Billing", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);


            PdfPTable table = new PdfPTable(6);
            // Add PDF Table Header ->
            Stream.of("Extra Name", "First Name", "Last Name","Price","Sub Price","Extra Cost Price")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });


            List<ExtraCost> extraCostList = getExtraCostList(login);


            //Get subscription price
            double subscriptionPrice = 0;
         //
            //
            //
            //
            //
            //
            //  subscriptionPrice = getSubscriptionPrice(login, subscriptionPrice);

            //Get extra cost
            double extraPrice = 0;
            extraPrice = getExtraPriceSum(extraCostList, extraPrice);


            for (ExtraCost extraCost : extraCostList) {
                PdfPCell idCell = new PdfPCell(new Phrase(extraCost.getExtraname()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);


                PdfPCell firstNameCell = new PdfPCell(new Phrase(extraCost.getPerson().getFirstName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(extraCost.getPerson().getLastName())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);

                PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(extraCost.getPrice())));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(priceCell);

                PdfPCell subscriptionCell = new PdfPCell(new Phrase(String.valueOf(subscriptionPrice)));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(subscriptionCell);

                PdfPCell extraTotalCell = new PdfPCell(new Phrase(String.valueOf(extraPrice)));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(extraTotalCell);


            }
            document.add(table);

            document.close();
        }catch(DocumentException e) {
            LOG.error(e.toString());
        }


        return new ByteArrayInputStream(out.toByteArray());
    }

    private static double getExtraPriceSum(List<ExtraCost> extraCostList, double extraPrice) {
        for (ExtraCost extraCostElement :extraCostList) {
            extraPrice=+extraCostElement.getPrice();
        }
        LOG.info(String.valueOf(extraPrice));
        return extraPrice;
    }

 /* private double getSubscriptionPrice( String login, double subscriptionPrice) {
        //SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Person person = personDAO.findByLogin(login);
        login = login.replaceAll("=","");
        LOG.info(login);
        Subscription subscription = person.getSubscription();
        LOG.info(String.valueOf(subscription.getPrice()));
        /*
        long id = subscription.getId();

        Optional<Subscription> subscription = subscriptionDAO.findById(id);
        if(subscription.isPresent()){
            subscriptionPrice = subscription.get().getPrice();
        }
        LOG.info(String.valueOf(subscriptionPrice));


        return subscription.getPrice();
    }*/

  private List<ExtraCost> getExtraCostList(@Valid String login) {
        Person person = personDAO.findByLogin(login);
        login = login.replaceAll("=","");
        LOG.info(login);

        person = personDAO.findByLogin(login);
        List<ExtraCost> extraCOST = extraCostDAO.findByPerson(person);
        return extraCOST;
    }

}
