package org.shams.phonebook.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Jan 21, 2008
 */

public interface DomainObject extends Serializable {
    public void setId(Long id);
    public Long getId();
}
