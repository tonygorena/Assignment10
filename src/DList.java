/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author tonygorena
 */
public class DList<E> {

    private Link<E> head;   //first link in list
    private Link<E> tail;   //last link  in list
    private Link<E> curr;   //current link position

    private int cnt;                //amount of items in list

    /**
     * Constructor
     */
    DList() {
        curr = new Link<E>(null, head, tail);
        tail = new Link<E>(null, head, null);
        head = new Link<E>(null, null, tail);
        cnt = 0;

    }

    /**
     * Clear list
     */
    public void clear() {


        tail = new Link<E>(null, head, null);
        head = new Link<E>(null, null, tail);
        curr = head;
        cnt = 0;
    }

    /**
     * Insert item to beginning of list
     *
     * @param it the item to insert
     */
    public void insertBeginning(E it) {
        curr = head;                                //set curr to beginning
        this.insert(it);
    }

    /**
     * Insert item to list
     *
     * @param it the item to insert
     */
    public void insert(E it) {

        curr.setNext(new Link<E>(it, curr, curr.next()));  //Insert new link
        curr = curr.next();
        curr.next().setPrev(curr);           //set previous pointer
        cnt++;                                      //increment count
    }

    /**
     * Insert to list in alphabetical order
     *
     * @param it the item to insert
     */
    public void insertAlpha(E it) {

        this.sortAlpha();           //Sort list
        curr = head;                //set to beginning of list

        //set position in alphabetical order
        while (it.toString().compareToIgnoreCase(curr.next().element().toString()) > 0) {
            curr = curr.next();
        }

        this.insert(it);  //insert to list

    }


    /**
     * Sort list in alphabetical order
     */
    public void sortAlpha() {
        HeapSorter sorter = new HeapSorter();       //new HeapSorter
        String str[] = new String[cnt];             //new String array

        //insert to string array
        for (int i = 0; i < cnt; i++) {
            str[i] = this.showElement(i);
        }

        sorter.doSort(str);                         //sort array

        this.clear();                               //clear old list

        //insert to back to list
        for (int i = str.length - 1; i >= 0; i--) {
            this.insertBeginning((E) str[i]);
        }
    }

    /**
     * @return amount of items in list
     */
    public int count() {
        return cnt;
    }


    /**
     * remove item from list
     *
     * @param item the item to remove
     * @return error code
     */
    public int remove(String item) {
        if (cnt == 0){
            return -2;
        }
        if (this.find(item)== -4){
         return -4;
        }

        curr.next().setPrev(curr.prev()); //set previous field of next link

        curr.prev().setNext(curr.next()); //set next field of previous link




        cnt--;                              //decrement count
        return 0;

    }

    /**
     * find item in list
     *
     * @param item the item to find
     */
    public int find(String item) {
        curr = head;                //Set to beginning

        //Step through list until item is found
        for (int i = 0; i < cnt; i++) {
            if (item.toString().equals(curr.next().element().toString())) {
                curr = curr.next();
                return 0;
            } else {
                curr = curr.next();
            }
        }

        return -4;



    }


    /**
     * Show element in position
     *
     * @param index position to show
     * @return String in element
     */
    public String showElement(int index) {

        curr = head.next();

        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        String indexString = curr.element().toString();
        return indexString;

    }

    /**
     * show list
     */
    public void show() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(this.showElement(i));
        }
    }

}
