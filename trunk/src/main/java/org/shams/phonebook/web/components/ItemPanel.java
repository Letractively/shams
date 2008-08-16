package org.shams.phonebook.web.components;

import org.apache.tapestry5.annotations.Parameter;
import org.shams.phonebook.domain.impl.Item;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Dec 31, 2007
 */
public class ItemPanel {

    @Parameter(required = true)
    private Item item;

    @Parameter
    private String readOnly;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }
}
