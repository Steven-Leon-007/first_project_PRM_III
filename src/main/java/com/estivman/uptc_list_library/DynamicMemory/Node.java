package com.estivman.uptc_list_library.DynamicMemory;


public class Node<T> {

    private T info;
    private Node<T> next;


    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
