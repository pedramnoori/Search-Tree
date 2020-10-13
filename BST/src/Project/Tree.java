package Project;

import Project.Node;
import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedram
 */
//This class is BST but because stopword tree fill there , this class name is Tree.
public class Tree {

    FileReader FR;

    ArrayList<String> fileNamesList;
    String path;

    public Node root;
    public Node current;
    int height1 = 1 ;
    int height2 = 1 ;
//Cunstructor
    public Tree() {
        this.root = null;
        fileNamesList = new ArrayList<String>();
    }
//setFile for BST
    public void setFileNameList(String path) {
        this.path = path;
    }
//Function that Check exist an id in tree
    boolean Find(String id) {

        Node Current = root;
        while (Current != null) {
            if (Current.strData.compareTo(id) == 0) {
                current = Current;
                return true;
            } else if (Current.strData.compareTo(id) > 0) {
                Current = Current.left;
            } else {
                Current = Current.right;
            }
        }
        return false;

    }
    
//    void increaseLength(Node node) {
//        Node parent = node.parent;
//        if (parent != null) {
//      
//            parent.height += 1;
//            this.increaseLength(parent);
////            System.out.println("length = " + node.parent.strData + ", " + node.parent.height);   
//        }
//    }
    
 
    
//    void setBalanceFactor(Node node){
//       
//            if(node.left != null && node.right != null){
//                node.balanceFactor =  node.right.height- node.left.height;
//            }else if(node.left == null && node.right != null){
//                node.balanceFactor =  node.right.height;
//            }else if(node.right == null && node.left != null){
//                node.balanceFactor =   node.left.height;
//            }
//        if(node.parent != null) {
//            this.setBalanceFactor(node.parent);
//        }
////        System.out.println(node.strData);
//        if(Math.abs(node.balanceFactor) >1){
////            System.out.println(root.strData);
//            buildAVL(node);
////            System.out.println(node.left.left.strData);
//        System.out.println(root.strData);
//            System.out.println("=========");
//        }
////        System.out.println("BF  "+node.strData + " ," + node.balanceFactor);
//    }
//    void buildAVL(Node node){
//        if(node.left.left != null){
//            node.left.right = new Node(node.strData);
////            node.left.right = node;
//            root = node.left;
//            node=null;
//        
//        }
//    }
//    
//Function to insert words in BST
    void insert(String id) {
        Node Current = root;
        Node Parent = null;
        Node newNode = new Node(id);
//        int height = 1;

        if (root == null) {
//            System.out.println("Root");
                  
            root = newNode;
            root.parent = null;
//            root.height = 1;
            newNode.ref.insert(path);
            
        }
        else {
            while (true) {
                Parent = Current;
                if (id.compareTo(Current.strData) < 0) {
//                    height2++;
                    Current = Current.left;
                    if (Current == null) {
                        Parent.left = newNode;
                        height2++;
                        newNode.ref.insert(path);
                        newNode.parent = Parent;
//                        if(height > root.height) {
//                            
////                            this.increaseLength(newNode);
//                        }


                        return;
                    } else {
                        continue;
                    }

                }
                if (id.compareTo(Current.strData) > 0) {
//                    height1++;
//                    System.out.println(height1);
                    Current = Current.right;
    
                    if (Current == null) {
                        Parent.right = newNode;
                        height1++;
                        if(newNode.strData.equals("a"))
                            System.out.println("");
                        newNode.ref.insert(path);
                        newNode.parent = Parent;

                        return;
                    } else {
                        continue;
                    }

                }
                if (id.compareTo(Current.strData) == 0) {
                    Current.ref.insert(path);
                    return;
                }
            }
        }
//        System.out.println("  1:  "+height1 +"   2:  "+height2);
    }
    void getHeight(){
//        System.out.println(height1);
//        System.out.println(height2);
        int a = Math.max(height2, height1);
        System.out.println("Height of BST is : "+a);
    }
    


//    boolean Delete(String id) {
//        Node Current = root;
//        Node Parent = root;
//        boolean isLeftChild = false;
//        while (id.compareTo(Current.strData) != 0) {
//            Parent = Current;
//            if (id.compareTo(Current.strData) < 0) {
//                Current = Current.left;
//                isLeftChild = true;
//            }
//            if (id.compareTo(Current.strData) > 0) {
//                Current = Current.right;
//                isLeftChild = false;
//            }
//            if (Current == null) {
//                return false;
//            }
//        }
//        if (Current.right == null && Current.left == null) {
//            if (Current == root) {
//                root = null;
//            }
//            if (isLeftChild) {
//                Parent.left = null;
//
//            } else {
//                Parent.right = null;
//            }
//        } else if (Current.right == null) {
//            if (Current == root) {
//                root = Current.left;
//            } else if (!isLeftChild) {
//                Parent.right = Current.left;
//            } else {
//                Parent.left = Current.left;
//            }
//        } else if (Current.left == null) {
//            if (Current == root) {
//                root = Current.right;
//
//            } else if (!isLeftChild) {
//                Parent.right = Current.right;
//            } else {
//                Parent.left = Current.right;
//            }
//        } else if (Current.right != null && Current.right != null) {
//            Node successor = FindDelete(Current);
//            if (Current == root) {
//                root = successor;
//            } else if (isLeftChild) {
//                Parent.left = successor;
//            } else {
//                Parent.right = successor;
//            }
//            successor.left = Current.left;
//        }
//        return true;
//    }
//
//    public Node FindDelete(Node deleteNode) {
//        Node successsor = null;
//        Node successsorParent = null;
//        Node current = deleteNode.right;
//        while (current != null) {
//            successsorParent = successsor;
//            successsor = current;
//            current = current.left;
//        }
//     
//        if (successsor != deleteNode.right) {
//            successsorParent.left = successsor.right;
//            successsor.right = deleteNode.right;
//        }
//        return successsor;
//    }
//Function for traverse nodes 
    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.strData);
            root.ref.display();
            display(root.right);
        }
    }
    
    
    String GUI_TEXT = "";
//Function for set in gui file and linkedlist file
    public void set_GUI_TEXT(Node root) {
        if (root != null) {
            set_GUI_TEXT(root.left);
            GUI_TEXT += root.strData+ "\n";
            GUI_TEXT += root.ref.get_ref_GUI_TEXT();
            set_GUI_TEXT(root.right);
        }
    }
//Function that set data in Jtextarea
    public void GUI_display(Node root, JTextArea textarea) {
        getHeight();
        this.GUI_TEXT = " ";
        set_GUI_TEXT(root);
        textarea.setText(this.GUI_TEXT);
    }

    
    
}
