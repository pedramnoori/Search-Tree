package Project;

import java.util.NoSuchElementException;
import javax.swing.JTextArea;


public class AVLTreeST<Key extends Comparable<Key>, Value> {

    public Node root;
    String path;

    
    public class Node {
        public final Key key;   
        public Value val;       
        public int height;      
        public int size;        
        public Node left;       
        public Node right;      

        public Node(Key key, Value val, int height, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.height = height;
        }
    }


    public AVLTreeST() {
    }

    public void setFileNameList(String path) {
        this.path = path;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public int size() {
        return size(root);
    }


    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }


    public int height() {
        return height(root);
    }


    private int height(Node x) {
        if (x == null) return -1;
        return x.height;
    }


//    public Value get(Key key) {
//        if (key == null) throw new IllegalArgumentException("argument to get() is null");
//        Node x = get(root, key);
//        if (x == null) return null;
//        return x.val;
//    }


//    private Node get(Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) return get(x.left, key);
//        else if (cmp > 0) return get(x.right, key);
//        else return x;
//    }


//    public boolean contains(Key key) {
//        return get(key) != null;
//    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        root = put(root, key, val);
        assert check();
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 0, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.val = val;
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private Node balance(Node x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        }
        else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }


    private int balanceFactor(Node x) {
        return height(x.left) - height(x.right);
    }


    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }


    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private boolean check() {
        return isBST() && isAVL();
    }


    private boolean isAVL() {
        return isAVL(root);
    }


    private boolean isAVL(Node x) {
        if (x == null) return true;
        int bf = balanceFactor(x);
        if (bf > 1 || bf < -1) return false;
        return isAVL(x.left) && isAVL(x.right);
    }

    
    private boolean isBST() {
        return isBST(root, null, null);
    }

    

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    
        public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.key);
//            root.ref.display();
            display(root.right);
        }
    }
            String GUI_TEXT = "";
//Function for set in gui file and linkedlist file
    public void set_GUI_TEXT(Node root) {
        if (root != null) {
            set_GUI_TEXT(root.left);
            GUI_TEXT += root.key+ "\n";
//            GUI_TEXT += root.ref.get_ref_GUI_TEXT();
            set_GUI_TEXT(root.right);
        }
    }
//Function that set data in Jtextarea
    public void GUI_display(Node root, JTextArea textarea) {
        this.GUI_TEXT = " ";
        set_GUI_TEXT(root);
        textarea.setText(this.GUI_TEXT);
    }
    
}