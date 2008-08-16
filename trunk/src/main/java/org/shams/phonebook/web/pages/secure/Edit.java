package org.shams.phonebook.web.pages.secure;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.shams.phonebook.domain.impl.Item;
import org.shams.phonebook.service.ItemService;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */

public class Edit {
    @Persist
    private Item item;

    @Inject
    @Service("itemService")
    private ItemService itemService;

    public void setup(long id) {
        item = itemService.load(id);
    }

    @OnEvent(value = "submit")
    public Object save() {
        itemService.update(item);
        return List.class;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
