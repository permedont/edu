package ru.dbjpa;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact findById(final Long id);
}
