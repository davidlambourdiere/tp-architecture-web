package com.lifetech.util;


import com.itextpdf.text.pdf.PdfWriter;
import com.lifetech.domain.dao.ExtraCostDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.domain.model.ExtraCost;

import com.lifetech.domain.model.Person;
import com.lifetech.domain.model.Subscription;
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


            PdfPTable table = new PdfPTable(8);
            // Add PDF Table Header ->
            Stream.of("Last Name", "First Name", "Subscription Name","Subscription Price","Extra Cost Name","Extra Cost Price","Extra Cost Total","TTC Price")
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
            String subName = getSubscriptionName(login);


            //Get subscription price
            double subscriptionPrice = 0;
         //
            //
            //
            //
            //
            //
            subscriptionPrice = getSubscriptionPrice(login, subscriptionPrice);

            //Get extra cost
            double extraPrice = 0;
            extraPrice = getExtraPriceSum(extraCostList);

            double sumExtraPriceAndsubscriptionPrice = 0;
            sumExtraPriceAndsubscriptionPrice = extraPrice + subscriptionPrice ;

            for (ExtraCost extraCost : extraCostList) {

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(extraCost.getPerson().getLastName())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase(extraCost.getPerson().getFirstName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell nameSubscriptionCell = new PdfPCell(new Phrase(String.valueOf(subName)));
                nameSubscriptionCell.setPaddingLeft(4);
                nameSubscriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameSubscriptionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nameSubscriptionCell);

                PdfPCell subscriptionCell = new PdfPCell(new Phrase(String.valueOf(subscriptionPrice)));
                subscriptionCell.setPaddingLeft(4);
                subscriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                subscriptionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(subscriptionCell);


                PdfPCell extraNameCostCell = new PdfPCell(new Phrase(extraCost.getExtraname()));
                extraNameCostCell.setPaddingLeft(4);
                extraNameCostCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                extraNameCostCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(extraNameCostCell);



                PdfPCell extraCostPriceCell = new PdfPCell(new Phrase(String.valueOf(extraCost.getPrice())));
                extraCostPriceCell.setPaddingLeft(4);
                extraCostPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                extraCostPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(extraCostPriceCell);



                PdfPCell extraCostTotalCell = new PdfPCell(new Phrase(String.valueOf(extraPrice)));
                extraCostTotalCell.setPaddingLeft(4);
                extraCostTotalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                extraCostTotalCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(extraCostTotalCell);


                PdfPCell sumPriceTTCCell = new PdfPCell(new Phrase(String.valueOf(sumExtraPriceAndsubscriptionPrice)));
                sumPriceTTCCell.setPaddingLeft(4);
                sumPriceTTCCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                sumPriceTTCCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(sumPriceTTCCell);

            }
            document.add(table);

            document.close();
        }catch(DocumentException e) {
            LOG.error(e.toString());
        }


        return new ByteArrayInputStream(out.toByteArray());
    }

    private static double getExtraPriceSum(List<ExtraCost> extraCostList) {
        double extraPrice = 0;
        for (ExtraCost extraCostElement:extraCostList) {
            extraPrice = extraPrice + extraCostElement.getPrice();
            System.out.println(extraCostElement.getPrice());
        }
        LOG.info(String.valueOf(extraPrice));
        return extraPrice;
    }

    private double getSubscriptionPrice( String login, double subscriptionPrice) {
        //SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Person person = personDAO.findByLogin(login);
        login = login.replaceAll("=","");

        Subscription subscription = person.getSubscription();
      subscriptionPrice =  subscription.getPrice();
      return subscriptionPrice ;
    }

  private List<ExtraCost> getExtraCostList(@Valid String login) {
        Person person = personDAO.findByLogin(login);
        login = login.replaceAll("=","");

        person = personDAO.findByLogin(login);
        List<ExtraCost> extraCOST = extraCostDAO.findByPerson(person);
        return extraCOST;
    }

    private String getSubscriptionName( String login) {
        //SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Person person = personDAO.findByLogin(login);
        login = login.replaceAll("=","");

        Subscription subscription = person.getSubscription();
       String subName =  subscription.getName();
        return subName ;
    }

}
