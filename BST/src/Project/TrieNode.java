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
public class TrieNode {

    /**
     * 
     */
    TrieNode child[] = new TrieNode[26];
    int childNum;
    char chData;
    boolean isEnd;
    LinkedList ref;
    int end;

    public TrieNode(char chData) {
        this.chData = chData;
        this.ref = new LinkedList();
        for (int i = 0; i < child.length; i++) {
            child[i] = null;
        }
        isEnd = false;
        childNum = 0;
        end = 0;

    }
}
