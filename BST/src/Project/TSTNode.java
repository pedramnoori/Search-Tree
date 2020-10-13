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
public class TSTNode {
    

    char data;
    LinkedList ref;
    boolean isEnd;
    TSTNode left, middle, right;
 
    /** Constructor **/
    public TSTNode(char data)
    {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
        this.ref = new LinkedList();
        
    }        
}

