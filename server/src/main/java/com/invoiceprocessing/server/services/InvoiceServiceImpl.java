package com.invoiceprocessing.server.services;

import com.invoiceprocessing.server.dao.InvoiceDao;
import com.invoiceprocessing.server.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{


   //** Jpa is in the invoiceDao and contains inbuild methods
    @Autowired
    InvoiceDao invoiceDao ;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        //** Saves the data in db
        invoiceDao.save(invoice);
        //** Returns the saved data to the controller
        return invoice ;
    }
    @Override
    public List<Invoice> getInvoices(){
        return invoiceDao.findAll();
    }

    @Override
    public Invoice deleteInvoice(long id) {
        Invoice invoice = invoiceDao.findById(id).get();
        invoiceDao.delete(invoice);
        return invoice ;
    }

}
