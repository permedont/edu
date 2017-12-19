package ru.dbjpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="P_CONTACT")
@NamedQueries({
        @NamedQuery(name="Contact.findAll",query = "select c from Contact c"),
@NamedQuery(name = "Contact.findById",
        query = "select distinct c from Contact c where c.id = :id")
})
public class Contact implements Serializable {

    private Long id;
    private String name;
    private String addr;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    @Column(name="ADDR")
    public String getAddr() {
        return addr;
    }

    public void setAddr(final String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
