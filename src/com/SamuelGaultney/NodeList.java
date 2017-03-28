package com.SamuelGaultney;

/**
 * Created by Samuel on 3/27/2017.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void transverse(ListItem root);
}
