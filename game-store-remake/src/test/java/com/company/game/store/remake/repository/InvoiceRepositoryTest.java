package com.company.game.store.remake.repository;

import com.company.game.store.remake.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InvoiceRepositoryTest {
    @Autowired
    InvoiceRepository repo;

    Customer customer1;
    Game game1;
    Console console1;
    TShirt tshirt1;
    List<InvoiceItem> invoiceItems;

    Invoice invoice1 = new Invoice();
    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
        initizer();
    }

    public void initizer() {
        customer1 = new Customer("simon","7044444444","junk station, 28219");
        game1 = new Game(new BigDecimal(10.99), 2,"Konami", "E");
        console1 = new Console(new BigDecimal(10.99), 1,"Sony", "intel 4");
        tshirt1 = new TShirt(new BigDecimal(1.99), 1,"Avengers", "XXXL");
        invoiceItems = new ArrayList<>();
        invoiceItems.add(game1);
        invoiceItems.add(console1);
        invoiceItems.add(tshirt1);
    }

    @Test
    public void testCreateInvoiceWithCustomerAndItems(){
        // uni direction from invoice to customer
        invoice1.setCustomer(customer1);

        // bi- direction between invoice item and invoice
        invoiceItems.stream().forEach(invoiceItem -> {
            invoiceItem.setInvoice(invoice1);
        });
        invoice1.setInvoiceItems(invoiceItems);

        invoice1 = repo.save(invoice1);
        assertEquals(3,invoice1.getInvoiceItems().size());
    }


}