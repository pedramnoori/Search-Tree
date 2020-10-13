/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import javax.swing.JTextArea;

/**
 *
 * @author pedram
 */
public class Hash {

    private int size;
    String path;

    public Tree[] hashArray;

    public Hash(int size) {
        this.size = size;
        this.hashArray = new Tree[size];
        for (int i = 0; i < size; i++) {
            this.hashArray[i] = new Tree();
        }
    }

    public void setFileNameList(String path) {
        this.path = path;
    }

    public void add(String name) {

        int code = name.hashCode();
        if (code <= 0) {
            code = -1 * code;
        }
        int index = code % size;
        hashArray[index].path = this.path;
        hashArray[index].insert(name);

    }

    public boolean find(String name) {

        int code = name.hashCode();
        if (code <= 0) {
            code = -1 * code;
        }
        int index = code % size;
        return hashArray[index].Find(name);

    }
    String GUI_TEXT = "";

    public void set_GUI_TEXT(Node root) {

        if (root != null) {
            set_GUI_TEXT(root.left);
            GUI_TEXT += root.strData + "\n";

            GUI_TEXT += root.ref.get_ref_GUI_TEXT();
            set_GUI_TEXT(root.right);
        }
    }

    public void show() {

        for (int i = 0; i < size; i++) {
          if(hashArray[i].path == null){
              System.out.println("Sag berine dahane banif");
          }
            set_GUI_TEXT(hashArray[i].root);
   
            
        }
    }
    public void GUI_display(JTextArea textarea) {
//        System.out.println(hashArray[0].root.ref.first.fileName);
        this.GUI_TEXT = " ";
        show();
        textarea.setText(this.GUI_TEXT);
    }

}


