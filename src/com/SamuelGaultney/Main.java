package com.SamuelGaultney;

public class Main {

    public static void main(String[] args) {


        //MyLinkedList list = new MyLinkedList(null);  change tree to list, refactor
        SearchTree tree = new SearchTree(null);
        tree.transverse(tree.getRoot());

        String stringData = "Atlanta Pheonix Seattle Nashville Houston Athens Sacramento Charleston";
        String[] data = stringData.split(" "); //returns string array with defined items
        for (String s : data) {
            //create new item with value set to the string s
            tree.addItem(new Node(s));
        }

        tree.transverse(tree.getRoot());
        tree.removeItem(new Node("Seattle"));
        tree.transverse(tree.getRoot());

        tree.removeItem(new Node("Houston"));
        tree.transverse(tree.getRoot());

    }
}
