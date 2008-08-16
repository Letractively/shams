package org.shams.phonebook.web.pages.secure;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.shams.phonebook.domain.impl.Item;
import org.shams.phonebook.service.ItemService;

import java.util.Collection;

/**
 * @author <a href="mailto:m.h.shams@gmail.com">M. H. Shamsi</a>
 * @version 1.0.0
 *          Date Oct 14, 2007
 */
public class List {
    private Item item;

    @InjectPage
    private Edit edit;

    @InjectPage
    private View view;

    @Persist
    private String searchItem;

    @Inject
    @Service("itemService")
    private ItemService itemService;

    @OnEvent(value = "action", component = "edit")
    Object edit(int id) {
        edit.setup(id);
        return edit;
    }

    @OnEvent(value = "action", component = "view")
    Object view(int id) {
        view.setup(id);
        return view;
    }

    @OnEvent(value = "action", component = "delete")
    void delete(long id) {
        getItem().setId(id);
        itemService.delete(item);
    }

    public Collection<Item> getItems() {
        return itemService.load(searchItem);
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

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }
}
