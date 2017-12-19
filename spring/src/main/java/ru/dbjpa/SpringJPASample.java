package ru.dbjpa;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJPASample {

    public static void main(final String[] args) {
        final GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        final ContactService contactService = ctx.getBean(
                "jpaContactService", ContactService.class);
        final List<Contact> allContacts = contactService.findAll();
        final Contact contact = contactService.findById(1L);
        System.out.println(allContacts);
        System.out.println(contact);

    }

}
