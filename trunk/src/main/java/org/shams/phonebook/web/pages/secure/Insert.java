package org.shams.phonebook.web.pages.secure;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.shams.phonebook.domain.impl.Item;
import org.shams.phonebook.service.ItemService;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */
public class Insert {
    private Item item;

    @Inject
    @Service("itemService")
    private ItemService itemService;

    @OnEvent(value = "submit")
    public Object save() {
        itemService.save(item);
        return List.class;
    }

    public Item getItem() {
        if (item == null) {
            item = new Item();
        }
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
