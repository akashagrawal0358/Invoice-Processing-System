package com.invoiceprocessing.server.controller;


import com.invoiceprocessing.server.model.Invoice;
import com.invoiceprocessing.server.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles request received from frontend
@RestController
@CrossOrigin
public class InvoiceController {

    //  Creates object of interface
   @Autowired
   InvoiceService invoiceService;

// axios.post(`${API_URL}/invoice`, payload);
// Invoice is a model that stores data, validate data
 @PostMapping("/invoice")
 public Invoice addInvoice(@RequestBody Invoice invoice){
     // 1 ----> Calls the InvoiceService
     return this.invoiceService.addInvoice(invoice);
     // 2 <----- Returns the data to frontend that receive from InvoiceServiceImpl
 }

 @GetMapping("/invoice")
 public List<Invoice> getInvoices(){
     return this.invoiceService.getInvoices();
 }

 @DeleteMapping("/invoice/{invoiceId}")
 public Invoice deleteInvoice(@PathVariable String invoiceId) {
     // Convert string into long
     return this.invoiceService.deleteInvoice(Long.parseLong(invoiceId));
 }

}
