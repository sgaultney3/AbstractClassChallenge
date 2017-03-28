package com.SamuelGaultney;

/**
 * Created by Samuel on 3/27/2017.
 */
public abstract class ListItem {
    protected ListItem rightLink = null; //protected so that some classes can access and others cant
    protected ListItem leftLink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
