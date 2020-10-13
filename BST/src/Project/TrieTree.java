/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author pedram
 */
//Class for Trie Tree
public class TrieTree {

    TrieNode root;
    TrieNode curr;
    char ch;
    int index;
    String path;
//Cunstructor
    public TrieTree() {
        root = new TrieNode(' ');
        curr = root;
    }
//Set files
    public void setFileNameList(String path) {
        this.path = path;
    }
//Function for insert words
    public void insert(String word) {
        word = word.toLowerCase();

        for (int j = 0; j < word.length(); j++) {
            ch = word.charAt(j);

            index = ch - 'a';
            
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode(ch);
                curr = curr.child[index];
            } else {
                curr = curr.child[index];
            }
            if (word.length() == j + 1) {
                curr.isEnd = true;
                curr.end = 1;
                curr.ref.insert(path);
                curr = root;
                
            }

        }

    }
//Funtion for search a word
    public boolean search(String word) {
        word = word.toLowerCase();
        char c;
        int ind = 0;
        curr = root;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            ind = c - 'a';
            if (curr.child[ind] != null) {
                curr = curr.child[ind];
            }else
                return false;
        }
        if (curr.isEnd) {
            return true;
        }

        return false;

    }
//Function for traverse ids
    public void display(TrieNode node, String str) {  
        if (node.isEnd) {
            System.out.println(str);
            node.ref.display();
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    display(node.child[i], str + node.child[i].chData);
                }
            }
            return;
        }
        for (int i = 0; i < node.child.length; i++) {
            if (node.child[i] != null) {

                display(node.child[i], str + node.child[i].chData);
            }
        }
    }
    
    String GUI_TEXT = "";
//Set in gui and linkedlist
    public void set_GUI_TEXT(TrieNode node , String str) {
       if (node.isEnd) {
            GUI_TEXT +=str;
            GUI_TEXT +=node.ref.get_ref_GUI_TEXT();
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    set_GUI_TEXT(node.child[i], str + node.child[i].chData);
                }
            }
            return;
        }
        for (int i = 0; i < node.child.length; i++) {
            if (node.child[i] != null) {

                set_GUI_TEXT(node.child[i], str + node.child[i].chData);
            }
        }
    }
//Set in JTextarea
    public void GUI_display(TrieNode root, JTextArea textarea) {
        this.GUI_TEXT = " ";
        set_GUI_TEXT(root,"");
        textarea.setText(this.GUI_TEXT);
       
    }

}
    
    


