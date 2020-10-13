package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author pedram
 */
//Class for read and some functions for files
public class FileReader {

    int number = 0;
    File file;
    File file2;
    File file3;
    File file4;
    File file5;
    File file6;
    File file7;
    File file8;
    String str;
    Tree stopWordTree;
    Tree wordTree;
    TST tst;
    TrieTree treeTrie;
    AVLTreeST AVLBst;
    Hash hash;
    FileReader f;
    String pathDelete;
    ArrayList<String> m = new ArrayList();
    int a = 0;
    String Directory;
    Scanner s = new Scanner(System.in);
    ArrayList<String> addedFileNameBST = new ArrayList();
    ArrayList<String> addedFileNameTrie = new ArrayList();
    ArrayList<String> addedFileNameTST = new ArrayList();
    ArrayList<String> addedFileNameAVL = new ArrayList();
    ArrayList<String> addedFileNameHash = new ArrayList();
//Get name of files    

    public void FileDirectory(String directory) {

        File file = new File(directory);
        File[] list = file.listFiles();
        for (File item
                : list) {
            if (!item.getAbsolutePath().equals(pathDelete)) {
                if (item.isDirectory()) {
                    FileDirectory(item.getAbsolutePath());

                } else if (!item.getAbsolutePath().equals("/Users/pedram/Downloads/Data Structure/HomeWorks/Project 1/SS/.DS_Store")) {
                    m.add(item.getAbsolutePath());
                    number++;
                }
            }
        }

    }
//Cunstructor

    public FileReader() {

        stopWordTree = new Tree();
        wordTree = new Tree();
        treeTrie = new TrieTree();
        tst = new TST();
        AVLBst = new AVLTreeST();
        System.out.println("Enter size of hashMap");
        int size = s.nextInt();
        hash = new Hash(size);

    }
//Create stop word tree

    public void stopWTree() {

        file = new File("/Users/pedram/Downloads/Data Structure/Project 1/StopWords.txt");

        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                str = s.next();
                str = str.toLowerCase();
                stopWordTree.setFileNameList(file.getName());
                stopWordTree.insert(str);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//little method for some extra words

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
//Insert words that select user in BinarySearchTree 

    void addFile(String path, String dirc) {

        file4 = new File(dirc + "/" + path + ".txt");
        wordTree.setFileNameList(file4.getName().replace(".txt", ""));
        a++;
        try {
            Scanner s = new Scanner(file4);
            while (s.hasNext()) {
                str = s.next();
                str = str.toLowerCase();
                if (!stopWordTree.Find(str) && this.isAlpha(str)) {
                    wordTree.insert(str);
//                    System.out.println(wordTree.height());

                }
//                System.out.println(wordTree.height());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
//Insert words that select user in Trie tree

    void addFile2(String path, String dirc) {

        file5 = new File(dirc + "/" + path + ".txt");
        treeTrie.setFileNameList(file5.getName().replace(".txt", ""));
        a++;
        try {
            Scanner s = new Scanner(file5);
            while (s.hasNext()) {
                str = s.next();

                str = str.toLowerCase();
                if (!stopWordTree.Find(str) && this.isAlpha(str)) {
                    treeTrie.insert(str);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
//Insert words that select user in tarnerySearchTree

    void addFile3(String path, String dirc) {

        file6 = new File(dirc + "/" + path + ".txt");
        tst.setFileNameList(file6.getName().replace(".txt", ""));
        a++;

        try {
            Scanner s = new Scanner(file6);
            while (s.hasNext()) {
                str = s.next();
                str = str.toLowerCase();
                if (!stopWordTree.Find(str) && this.isAlpha(str)) {
                    tst.insert(str, file6.getName());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addFile4(String path, String dirc) {
        file7 = new File(dirc + "/" + path + ".txt");
        AVLBst.setFileNameList(file7.getName().replace(".txt", ""));
        a++;

        try {
            Scanner s = new Scanner(file7);
            while (s.hasNext()) {
                str = s.next();
                str = str.toLowerCase();
                if (!stopWordTree.Find(str) && this.isAlpha(str)) {
                    AVLBst.put(str, file7.getName());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    void addFileHash(String path, String dirc) {

        file8 = new File(dirc + "/" + path + ".txt");
        hash.setFileNameList(file8.getName().replace(".txt", ""));
        a++;
        try {
            Scanner s = new Scanner(file8);
            while (s.hasNext()) {
                str = s.next();

                str = str.toLowerCase();
                if (!stopWordTree.Find(str) && this.isAlpha(str)) {
                    hash.add(str);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
//Delete files that user want

    public void deleteBST(String fileName) {
        wordTree.root = null;
        int counter = a;
        a = 0;

        for (int i = 0; i < (counter); i++) {
            if (!addedFileNameBST.get(i).equals(fileName)) {
                addFile(addedFileNameBST.get(i), Directory);
            }
        }
    }

    public void deleteTST(String fileName) {
        tst.root = null;
        int counter = a;
        a = 0;
        for (int i = 0; i < (counter); i++) {
            if (!addedFileNameTST.get(i).equals(fileName)) {
                addFile3(addedFileNameTST.get(i), Directory);
            }
        }
    }

    public void deleteTrie(String fileName) {
        for (int i = 0; i < treeTrie.root.child.length; i++) {
            treeTrie.root.child[i] = null;
        }
        int counter = a;
        a = 0;

        for (int i = 0; i < (counter); i++) {
            if (!addedFileNameTrie.get(i).equals(fileName)) {
                addFile2(addedFileNameTrie.get(i), Directory);
            }
        }
    }

    public void deleteAVL(String fileName) {
        AVLBst.root = null;

        int counter = a;
        a = 0;

        for (int i = 0; i < (counter); i++) {
            if (!addedFileNameAVL.get(i).equals(fileName)) {
                addFile4(addedFileNameAVL.get(i), Directory);
            }
        }
    }
    public void deleteHash(String fileName){
        for(int i = 0 ; i<hash.hashArray.length ; i++){
            hash.hashArray[i].root=null;
        }
        int counter = a;
        a = 0;
        for(int i = 0; i< (counter); i++){
            if(!addedFileNameHash.get(i).equals(fileName)){
                addFileHash(addedFileNameHash.get(i), Directory);
            }
        }
    }

//Update which files whose changed
    public void updateBST(String fileName) {
        wordTree.root = null;

        int counter = a;
        a = 0;
        for (int i = 0; i < (counter); i++) {
            addFile(addedFileNameBST.get(i), Directory);

        }
    }

    //Update which files whose changed
    public void updateTrie(String fileName) {
        for (int i = 0; i < treeTrie.root.child.length; i++) {
            treeTrie.root.child[i] = null;
        }
        int counter = a;
        a = 0;
        for (int i = 0; i < (counter); i++) {
            addFile2(addedFileNameTrie.get(i), Directory);

        }
    }

    //Update which files whose changed
    public void updateTST(String fileName) {

        tst.root = null;
        int counter = a;
        a = 0;
        for (int i = 0; i < (counter); i++) {
            addFile3(addedFileNameTST.get(i), Directory);

        }
    }

    public void updateAVL(String fileName) {
        AVLBst.root = null;

        int counter = a;
        a = 0;
        for (int i = 0; i < (counter); i++) {
            addFile4(addedFileNameAVL.get(i), Directory);

        }
    }
    public void updateHash(String fileName){
        for(int i = 0 ; i<hash.hashArray.length ; i++){
            hash.hashArray[i].root=null;
        }
        int counter = a;
        a = 0;
        for(int i = 0; i< (counter); i++){
            addFileHash(addedFileNameHash.get(i), Directory);
        }
    }

}
