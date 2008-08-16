package org.shams.phonebook.domain.impl;

import org.shams.phonebook.domain.DomainObject;

import javax.persistence.*;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 21, 2008
 */

@MappedSuperclass
public class DomainObjectImpl implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Object ID: " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        DomainObjectImpl that = (DomainObjectImpl) obj;

        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? -1 : (int) id.longValue() * 7;
    }
}
