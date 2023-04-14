/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class Node {
    public Object data;
    public Node prev; //apuntador al nodo anterior
    public Node next; //apuntador al sgte nodo
    
    //Constructor
    public Node(Object data){
        this.data = data;
        this.prev = this.next = null;
    }
}
