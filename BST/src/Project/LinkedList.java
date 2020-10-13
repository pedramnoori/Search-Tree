/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author pedram
 */
//Class for linkedlist that have filename
public class LinkedList {

    LinkedListNode first;
    LinkedListNode last;
//Cunstructor
    public LinkedList() {

        last = first = null;
    }
//Insert in linkedlist
    void insert(String fileName) {
        LinkedListNode current = first;

        while (current != null) {
            if (fileName.equals(current.fileName)) {
                current.number++;
                return;

            } else {
                current = current.right;
            }

        }
        LinkedListNode nd = new LinkedListNode(fileName);

        if (first == null) {
            last = first = nd;

        } else {
            last.right = nd;
            last = nd;
        }
    }
//Delete in linkedlist
    void delete(String dlFileName) {

        LinkedListNode current = first.right;
        LinkedListNode parent = first;
        if (parent.fileName.equals(dlFileName)) {
            parent = null;
            current = first;
        } else {
            while (current != null) {
                if (current.fileName.equals(dlFileName)) {

                    parent.right = current.right;
                    current = null;
                    return;
                }
                parent = current;
                current = current.right;
            }
        }
    }
//Search a filename in linkedlist
    public LinkedListNode search(String fileName) {
        LinkedListNode current = first;

        while (current != null) {
            if (!current.fileName.equals(fileName)) {
                current = current.right;

            } else {
                return current;
            }

        }
        return null;
    }
//Display linkedlist node (dar in barname karbord nadare vali vase faaze 2 lazem shayad beshe) 
//vase hamin paak nakardam.
    void display() {
        LinkedListNode current = first;

        while (current != null) {
            System.out.print(current.fileName + " : " + current.number + "\t");
            current = current.right;
        }
        System.out.println("\n");
    }
//Display linkedlist node
    public String get_ref_GUI_TEXT() {
        LinkedListNode current = first;
        String str = "";
        while (current != null) {
//            if(current == null){
//                System.out.println("current is null");
//            }
//            if(current.fileName == null){
//                System.out.println("fileName is null");
//            }
            str += "  -->" + current.fileName + " : " + current.number + "\t";
            current = current.right;
        }
        str += '\n';
        return str;
    }

}
