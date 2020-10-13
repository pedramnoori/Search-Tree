/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author pedram
 */
public class GUI extends JFrame {

    String strFileAddress;
    ArrayList<String> listedFile = new ArrayList();
    ArrayList<String> deleteFile = new ArrayList();

    public GUI() {
        super("Inverted index");

        FileReader f = new FileReader();
//Build stop word tree
        f.stopWTree();

//Creat a panel
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JRadioButton bst = new JRadioButton("BST");
        JRadioButton tst = new JRadioButton("TST");
        JRadioButton trie = new JRadioButton("Trie");
        JRadioButton avl = new JRadioButton("AVL");
        JRadioButton hash = new JRadioButton("Hash");

        ButtonGroup colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(bst);
        colorButtonGroup.add(tst);
        colorButtonGroup.add(trie);
        colorButtonGroup.add(avl);
        colorButtonGroup.add(hash);
        JTextField Address = new JTextField("", 10);
        JTextField tfCommand = new JTextField("", 30);
        JTextArea tree = new JTextArea(30, 40);
        JLabel lblAddress = new JLabel("Please Enter folder Address");

        JButton help = new JButton("Help");
        JButton build = new JButton("Build");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        JButton browse = new JButton("Browse");

//Add actionlisteners
        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strCommand = tfCommand.getText();
                if (strCommand.equals("list -w")) {
                    if (bst.isSelected()) {
                        
                        f.wordTree.GUI_display(f.wordTree.root, tree);
                        tree.setEditable(false);

                        JScrollPane scroll = new JScrollPane(tree);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        p.add(scroll);
                    } else if (trie.isSelected()) {
                        f.treeTrie.GUI_display(f.treeTrie.root, tree);
                        tree.setEditable(false);
                        
                        JScrollPane scroll = new JScrollPane(tree);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        p.add(scroll);
                    } else if (tst.isSelected()) {
                        f.tst.GUI_display(f.tst.root, tree);
                        tree.setEditable(false);
                        
                        JScrollPane scroll = new JScrollPane(tree);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        p.add(scroll);
                    }else if(avl.isSelected()){
                        f.AVLBst.GUI_display(f.AVLBst.root, tree);
                        tree.setEditable(false);
                        
                        JScrollPane scroll = new JScrollPane(tree);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        p.add(scroll);
                    }
                    else if(hash.isSelected()){
                        f.hash.GUI_display(tree);
                        tree.setEditable(false);
                        
                        JScrollPane scroll = new JScrollPane(tree);
                        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        p.add(scroll);
                    }

                } else if (strCommand.startsWith("add")) {
                    if(hash.isSelected()){
                        String s = strCommand.substring(4);
                        listedFile.add(s);
                        f.addedFileNameHash.add(s);
                        long a = System.nanoTime();
                        f.addFileHash(s, Address.getText());
                        long b = System.nanoTime();
                        System.out.println("Time to add "+s+" in Hash : "+(b-a));
                    }
                    else if (avl.isSelected()) {
                        String s = strCommand.substring(4);
                        listedFile.add(s);
                        f.addedFileNameAVL.add(s);
                        long a = System.nanoTime();
                        f.addFile4(s, Address.getText());
                        long b = System.nanoTime();
                        System.out.println("Time to add "+s+" in AVLBST : "+(b-a));
                    }
                        else if (bst.isSelected()) {
                        String s = strCommand.substring(4);
                        listedFile.add(s);
                        f.addedFileNameBST.add(s);
                        long a = System.nanoTime();
                        f.addFile(s, Address.getText());
                        long b = System.nanoTime();
                        System.out.println("Time to add "+s+" in BST : "+(b-a));
                    } else if (trie.isSelected()) {
                        String s = strCommand.substring(4);
                        listedFile.add(s);
                        f.addedFileNameTrie.add(s);
                        long a = System.nanoTime();
                        f.addFile2(s, Address.getText());
                        long b = System.nanoTime();
                        System.out.println("Time to add "+s+" in Trie Tree : "+(b-a));
                    } else if (tst.isSelected()) {
                        String s = strCommand.substring(4);
                        listedFile.add(s);
                        f.addedFileNameTST.add(s);
                        long a = System.nanoTime();
                        f.addFile3(s, Address.getText());
                        long b = System.nanoTime();
                        System.out.println("Time to add "+s+" in TST : "+(b-a));
                    }

                } else if (strCommand.startsWith("del")) {
                    if(avl.isSelected()){
                        String s = strCommand.substring(4);
                        deleteFile.add(s);
                        f.deleteAVL(s);                    
                    } else if (bst.isSelected()) {
                        String s = strCommand.substring(4);
                        deleteFile.add(s);
                        f.deleteBST(s);
                    } else if (trie.isSelected()) {
                        String s = strCommand.substring(4);
                        deleteFile.add(s);
                        f.deleteTrie(s);
                    } else if (tst.isSelected()) {
                        String s = strCommand.substring(4);
                        deleteFile.add(s);
                        f.deleteTST(s);
                    
                    } else if(hash.isSelected()){
                        String s = strCommand.substring(4);
                        deleteFile.add(s);
                        f.deleteHash(s);
                    }

                } else if (strCommand.equals("list -f")) {
                    String s = "";
                    for (int i = 0; i < f.m.size(); i++) {
                        s += f.m.get(i) + "\n";
                    }
                    tree.setText(s + "\n" + "Number of all docs : " + f.number);
                    JScrollPane scroll = new JScrollPane(tree);
                    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    p.add(scroll);

                } else if (strCommand.equals("list -l")) {
                    String m = "";

                    for (int j = 0; j < deleteFile.size(); j++) {
                        for (int k = 0; k < listedFile.size(); k++) {
                            if (!deleteFile.get(j).equals(listedFile.get(k))) {                             
                                m += listedFile.get(k) + "\n";

                            }
                        }
                    }
                    tree.setText("Selected file : " + "\n" + m + "");
                    JScrollPane scroll = new JScrollPane(tree);
                    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    p.add(scroll);

                } else if (strCommand.startsWith("search")) {
                    if (bst.isSelected()) {
                        String g = strCommand.substring(10);
                        long b = System.nanoTime();
                        boolean a = f.wordTree.Find(g);
                        long c = System.nanoTime();
                        System.out.println("Time to search "+g+"in BST : "+(c-b));
                        if (a) {
                            tree.setText(f.wordTree.current.ref.get_ref_GUI_TEXT());
                        }

                    } else if (trie.isSelected()) {
                        String g = strCommand.substring(10);
                        long b = System.nanoTime();
                        boolean a = f.treeTrie.search(g);
                        long c = System.nanoTime();
                        System.out.println("Time to search "+g+"in TrieTree : "+(c-b));
                        if (a) {
                            tree.setText(f.treeTrie.curr.ref.get_ref_GUI_TEXT());
                        }
                    } else if (tst.isSelected()) {
                        String g = strCommand.substring(10);
                        long b = System.nanoTime();
                        boolean a = f.tst.search(g);
                        long c = System.nanoTime();
                        System.out.println("Time to search "+g+"in TST : "+(c-b));
                        if (a) {
                            tree.setText(f.tst.current.ref.get_ref_GUI_TEXT());
                        }
                    }
                } else if (strCommand.startsWith("update")) {
                    if (bst.isSelected()) {
                        String s = strCommand.substring(7);
                        f.updateBST(s);
                    } else if (trie.isSelected()) {
                        String s = strCommand.substring(7);
                        f.updateTrie(s);
                    } else if (tst.isSelected()) {
                        String s = strCommand.substring(7);
                        f.updateTST(s);
                    }else if(avl.isSelected()){
                        String s = strCommand.substring(7);
                        f.updateAVL(s);
                    }else if(hash.isSelected()){
                        
                    }

                }

            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tree.setText("to work with this file , at first enter directory address"
                        + " and press the 'browse' button");
                JScrollPane scroll = new JScrollPane(tree);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                p.add(scroll);

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strFileAddress = Address.getText();
                f.Directory = Address.getText();
                long st = System.nanoTime();
                f.FileDirectory(strFileAddress);
                long ft = System.nanoTime();
                System.out.println("Time to read file : "+(ft - st));
                System.out.println("=============================");
            }
        });

        JLabel lblCommand = new JLabel("Enter Command : ");
//Add all tools
        p.add(lblAddress);
        p.add(Address);
        p.add(browse);
        p.add(tree);
        p.add(bst);
        p.add(tst);
        p.add(trie);
        p.add(avl);
        p.add(hash);
        p.add(build);
        p.add(reset);
        p.add(help);
        p.add(exit);
        p.add(lblCommand);
        p.add(tfCommand);
//Finally add panel :)
        add(p);
    }
}
