package ru.dbjpa;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll",
                Contact.class).getResultList();
        return contacts;
    }

    public Contact findById(final Long id) {
        TypedQuery<Contact> query = em.createNamedQuery(
                "Contact.findById", Contact.class);
        query. setParameter ( "id", id) ;
        return query.getSingleResult();
    }


}
