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
public class Node {

    Node right;
    Node left;
    Node parent;
    String strData;
    LinkedList ref;
    int balanceFactor;
    int height;
   

    public Node(String strData) {
        this.strData = strData;
        this.ref = new LinkedList();
        this.right = this.left = null;
        this.height = 1;
        this.balanceFactor =0;

    }

}
