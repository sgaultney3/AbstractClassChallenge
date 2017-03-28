package com.SamuelGaultney;

/**
 * Created by Samuel on 3/27/2017.
 */
public class SearchTree implements NodeList {

    //Utilizing a binary search tree as an alternative to linked list

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //the tree was empty, so our item is top of tree
            this.root = newItem;
            return true;
        }

        //otherwise compare from head of tree
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int compasrison = (currentItem.compareTo(newItem));
            if (compasrison < 0) {
                //newItem is greater, move right if possible
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //add because at end of tree, no node to the right
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (compasrison > 0) {
                //newItem is less, go left
                if(currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    //add on the left
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                //equal
                System.out.println(newItem.getValue() + " is already added");
                return  false;
            }
        }

        return false;
    }

    @Override //this is trickier than linked list because pointing the search tree is more complicated
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if ( comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                //equal, found so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }

        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if(item.next() == null) {
            //no right tree so make parent point to left tree
            if(parent.next() == item) {
                //item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                //item is left child
                parent.setPrevious(item.previous());
            } else {
                //parent is item, we are at root
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            //no left tree
            if(parent.next() == item) {
                //item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                //item is left child
                parent.setPrevious(item.next());
            } else {
                //parent is item, we are at root
                this.root = item.next();
            }
        } else {
            //neither left or right are null so it just got trickier, from the right tree, find left most value
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            //now put smallest value in node to delete
            item.setValue(current.getValue());
            //and delete smallest
            if (leftmostParent == item) {
                //there is no leftmost node so current points to smallest node
                item.setNext(current.next());
            } else {
                //set the smallest nodes parent to point to the smallest nodes right child (which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void transverse(ListItem root) {
        //recursive method
        if (root != null) {
            transverse(root.previous());
            System.out.println(root.getValue());
            transverse(root.next());
        }
    }
}
