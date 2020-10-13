/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author pedram
 */
//Class for tarnery Serach tree
public class TST {

    TSTNode root;
    ArrayList<String> al;
    String path;
    TSTNode current;


//Cunstructor
    public TST() {
        root = null;
    }
//set files
    public void setFileNameList(String path) {
        this.path = path;
    }

    
//Function to insert for a word  
    public void insert(String word,String fileName) {
        root = insert(root, word.toCharArray(), 0,path );
    }

    
//Function to insert for a word
    public TSTNode insert(TSTNode r, char[] word, int ptr, String fileName) {
        if (r == null) {
            r = new TSTNode(word[ptr]);
            if (word.length == 1){
                r.ref.insert(fileName);
                r.isEnd = true;
                return r;
            }
                
        }

        if (word[ptr] < r.data) {
            r.left = insert(r.left, word, ptr, fileName);
        } else if (word[ptr] > r.data) {
            r.right = insert(r.right, word, ptr, fileName);
        } else if (ptr + 1 < word.length) {
            r.middle = insert(r.middle, word, ptr + 1, fileName);
        } else {
            r.isEnd = true;
            r.ref.insert(fileName);
        }
        return r;
    }

//Function to search for a word
    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }


//Function to search for a word

    private boolean search(TSTNode r, char[] word, int ptr) {
        if (r == null) {
            return false;
        }

        if (word[ptr] < r.data) {
            return search(r.left, word, ptr);
        } else if (word[ptr] > r.data) {
            return search(r.right, word, ptr);
        } else if (r.isEnd && ptr == word.length - 1) {
            current =r;
            return true;
//            current =r;
        } else if (ptr == word.length - 1) {
            return false;
        } else {
            return search(r.middle, word, ptr + 1);
        }
    }


    
//Function that traverse nodes and ids
    public void display(TSTNode node, String str) {
        if (node == null) {
            return;
        }
        if (node.isEnd) {

            System.out.println(str+node.data);
            node.ref.display();
        }
        if (node.left != null) {
            display(node.left, str);
        }
        if (node.right != null) {
            display(node.right, str);
        }
        if (node.middle != null) {
            display(node.middle, str + node.data);
        }

    }
    String GUI_TEXT = "";
//Funtion for set in gui and linkedlist
    public void set_GUI_TEXT(TSTNode root , String str) {
       if (root == null) {
            return;
        }
        if (root.isEnd) {
            GUI_TEXT += str+root.data + "\n";
            GUI_TEXT +=root.ref.get_ref_GUI_TEXT();
        }
        if (root.left != null) {
            set_GUI_TEXT(root.left, str);
        }
        if (root.right != null) {
            set_GUI_TEXT(root.right, str);
        }
        if (root.middle != null) {
            set_GUI_TEXT(root.middle, str + root.data);
        }
    }
//Function that set in JTextarea
    public void GUI_display(TSTNode root, JTextArea textarea) {
        this.GUI_TEXT = " ";
        set_GUI_TEXT(root ,"");
        textarea.setText(this.GUI_TEXT);
    }


}
