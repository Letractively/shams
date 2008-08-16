package org.shams.phonebook.web.pages.secure;

import org.apache.tapestry5.annotations.InjectPage;
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
public class View {
    @Persist
    private Item item;

    @InjectPage
    private Edit edit;

    @Inject
    @Service("itemService")
    private ItemService itemService;

    public void setup(int id) {
        item = itemService.load(id);
    }

    @OnEvent(value = "submit")
    public Object edit() {
        edit.setup(item.getId());
        return edit;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
