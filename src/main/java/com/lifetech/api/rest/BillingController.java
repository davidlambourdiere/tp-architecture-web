package com.lifetech.api.rest;



import com.lifetech.domain.dao.ExtraCostDAO;
import com.lifetech.domain.dao.PersonDAO;
import com.lifetech.domain.dao.SubscriptionDAO;
import com.lifetech.util.PDFGenerator;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Service
public class BillingController extends RestBaseController{


    private final ExtraCostDAO extraCostDAO;
    private final PersonDAO personDAO;
    private final SubscriptionDAO subscriptionDAO;



    public BillingController(ExtraCostDAO extraCostDAO, PersonDAO personDAO, SubscriptionDAO subscriptionDAO) {
        this.extraCostDAO = extraCostDAO;
        this.personDAO = personDAO;
        this.subscriptionDAO = subscriptionDAO;

    }





    @GetMapping(value = "/billing/{login}",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> BillingReport(@PathVariable(value = "login") String login) throws IOException {
        //List<ExtraCost> extraCOST = extraCostDAO.findAll();

        PDFGenerator pdfGenerator = new PDFGenerator(extraCostDAO,personDAO,subscriptionDAO);
        ByteArrayInputStream bis = pdfGenerator.billingPDFReport(login);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=subscription.pdf");


        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
