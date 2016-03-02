package com.isatimur.ocp.package_2;

/**
 * Created by tisachenko on 18.02.16.
 */
class Node {
    Object value;
    Node left, right;
}

class Tree {
    Node rootNode;

    Tree() {

    }

    void addElement(Object value) {

    }

    void removeElement(Object value) {

    }

    void sortTree(boolean asceding) {
        new TreeSort(asceding).sort();
    }


    class TreeSort {
        boolean ascedingOrder = true;

        public TreeSort(boolean order) {
            ascedingOrder = order;
        }

        void sort() {

        }
    }
}
