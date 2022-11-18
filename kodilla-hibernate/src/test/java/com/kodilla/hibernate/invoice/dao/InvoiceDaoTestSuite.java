package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("IV/176/2022");
        Invoice invoice2 = new Invoice("IV/177/2022");

        Item item = new Item(new BigDecimal(120), 3);
        Item item2 = new Item(new BigDecimal(90), 4);
        Item item3 = new Item(new BigDecimal(150), 1);
        Item item4 = new Item(new BigDecimal(120), 1);
        Item item5 = new Item(new BigDecimal(90), 2);
        Item item6 = new Item(new BigDecimal(150), 2);

        Product product = new Product("6 foot table");
        Product product2 = new Product("4 foot table");
        Product product3 = new Product("4 foot bench seat");

        invoice.getItems().add(item);
        invoice.getItems().add(item3);
        invoice.getItems().add(item6);
        invoice2.getItems().add(item2);
        invoice2.getItems().add(item4);
        invoice2.getItems().add(item5);

        product.getItemsProduct().add(item3);
        product.getItemsProduct().add(item6);
        product2.getItemsProduct().add(item);
        product2.getItemsProduct().add(item4);
        product3.getItemsProduct().add(item2);
        product3.getItemsProduct().add(item5);

        item.setInvoice(invoice);
        item.setProduct(product2);
        item2.setInvoice(invoice2);
        item2.setProduct(product3);
        item3.setInvoice(invoice);
        item3.setProduct(product);
        item4.setInvoice(invoice2);
        item4.setProduct(product2);
        item5.setInvoice(invoice2);
        item5.setProduct(product3);
        item6.setInvoice(invoice);
        item6.setProduct(product);

        //When
        invoiceDao.save(invoice);
        Integer id = invoice.getId();

        invoiceDao.save(invoice2);
        Integer id2 = invoice2.getId();


        //Then
        assertNotEquals(0, id);
        assertNotEquals(0, id2);

        //CleanUp
//        invoiceDao.deleteById(id);
//        invoiceDao.deleteById(id2);
    }
}
