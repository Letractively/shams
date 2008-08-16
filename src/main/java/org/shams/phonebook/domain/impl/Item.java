package org.shams.phonebook.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */

@SuppressWarnings({"JpaDataSourceORMInspection"})
@Entity
@Table(name = "_ITEM")
public class Item extends DomainObjectImpl {
    @Column(name = "NAME")
    private String firstName;

    @Column(name = "FAMILY")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "ADDRESS")
    private String address;


    public Item() {
    }

    public Item(String firstName, String lastName, String phone, String mobile, String mail, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mobile = mobile;
        this.mail = mail;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
