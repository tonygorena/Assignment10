/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Link<E> {

    private E element; //value of node
    private Link<E> next; //Pointer to next node in list
    private Link<E> prev; //Pointer to previous node in list

    /**
     * Constructor
     *
     * @param it      value of element
     * @param nextVal next value
     */
    Link(E it, Link<E> prevVal, Link<E> nextVal) {
        element = it;
        next = nextVal;
        prev = prevVal;
    }

    /**
     * Constructor
     *
     * @param nextVal next value
     */
    Link(Link<E> prevVal, Link<E> nextVal) {
        next = nextVal;
        prev = prevVal;
    }

    // return next link
    public Link<E> next() {
        return next;

    }
    //return previous link
    public Link<E> prev() {
        return prev;
    }


    /**
     * set next link
     *
     * @param nextVal next value
     * @return next value
     */
    public Link<E> setNext(Link<E> nextVal) {
        next = nextVal;
        return next;
    }

    public Link<E> setPrev(Link<E> prevVal){
        prev = prevVal;
        return prev;
    }

    /**
     * @return element of link
     */
    public E element() {
        return element;
    }

    /**
     * set element of link
     */
    public E setElement(E it) {
        return element = it;
    }

}
