package com.estivman.secondproject.DynamicMemory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class UptcList<T> implements List<T> {

    private Node<T> header = null; // First node of the linked list
    private int size = 0; // Number of elements in the list

    @Override
    public boolean add(T info) { // add new node at the end of the list

        Node<T> temporal = new Node<T>(); // For temporal, new node created
        temporal.setInfo(info);
        temporal.setNext(null);

        if (header == null) { // if the list is empty, then assign it to the header
            header = temporal;
            size++;
            return true;
        } else {
            Node<T> lastOne = header;
            while (lastOne.getNext() != null) {
                lastOne = lastOne.getNext();
            }

            lastOne.setNext(temporal); // Here add the new node
            size++;
            return true;
        }
    }

    public void show() {
        Node<T> helper = header;
        while (helper != null) {
            System.out.println(helper.getInfo());
            helper = helper.getNext(); // The same, if is not null then equals to the next node
        }
    }

    public Node<T> getHeader() {
        return header;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        Node<T> aux = header;
        if (aux != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        try {
            Node<T> aux = header;
            while (aux != null) {
                if (aux.getInfo().equals(o)) {
                    return true;
                }
                aux = aux.getNext();
            }
            return false;
        } catch (NullPointerException e) {
            throw new NullPointerException("No existe el elemento en la lista");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new UptcListIterator<T>();
    }

    private class UptcListIterator<E> implements Iterator<T> {
        Node<T> aux = header;

        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay un elemento siguiente del mismo");
            }
            T info = aux.getInfo();
            aux = aux.getNext();
            return info;
        }

    }

    @Override
    public Object[] toArray() {
        try {
            Node<T> aux = header;
            Object[] result = new Object[this.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = aux.getInfo();
                aux = aux.getNext();
            }
            return result;
        } catch (NullPointerException e) {
            throw new NullPointerException("La lista no pudo ser convertida a Array");
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean remove(Object o) {
        try {
            Node<T> aux = header;
            Node<T> keeper = new Node<T>();

            if (aux.getInfo().equals(o)) {
                keeper = (aux.getNext());
                header = keeper;
                this.size--;
                return true;
            }

            while (aux.getNext() != null) {
                if (aux.getNext().getInfo().equals(o)) {
                    keeper.setNext(aux.getNext().getNext());
                    aux.setNext(keeper.getNext());
                    this.size--;
                    return true;
                }
                aux = aux.getNext();
            }
            throw new NullPointerException("El objeto a eliminar no existe en la lista");
        } catch (Exception e) {
            throw new NullPointerException("El objeto a eliminar no existe en la lista");

        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        this.header = null;
        this.size = 0;
    }

    @Override
    public T get(int index) {
        try {
            if (index < 0 || index >= this.size()) {
                throw new IndexOutOfBoundsException("El indice excede el tamaño de la lista");
            }
            Node<T> aux = header;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux.getInfo();

        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("El elemento no existe en la lista");
        }
    }

    @Override
    public T set(int index, T element) {
        try {
            if (index >= this.size()) {
                throw new IndexOutOfBoundsException("El indice excede el tamaño de la lista");
            }

            Node<T> aux = this.findNode(index);
            if (aux != null) {
                aux.setInfo(element);
                return aux.getInfo();
            }
            throw new NullPointerException("El elemento no existe en la lista");
        } catch (NullPointerException e) {
            throw new NullPointerException("Hubo un error: " + e.getMessage());
        }
    }

    @Override
    public void add(int index, T element) {
        try {
            Node<T> holder = new Node<T>();

            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("Que pelotudo que sos amigo");
            }
            Node<T> aux = header;
            // TODO: Just fix when there's just one element
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext(); // aux becomes the one behind where we want to add
            }
            if (aux.getNext().getNext() == null) {
                this.add(element);
            } else {
                holder.setNext(aux.getNext()); // keeps the element where we want to add it (in this case "uno");
                holder.setInfo(element);
                aux.setNext(holder);
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Que pelotudo que sos amigo");
        }
    }

    @Override
    public T remove(int index) {
        try {
            Node<T> keeper = new Node<T>();
            Node<T> aux = this.findNode(index - 1);
            T removedElement = aux.getNext().getInfo();

            if (index == 0) {
                keeper = (aux.getNext());
                header = keeper;
                this.size--;
                return aux.getInfo();
            }

            keeper.setNext(aux.getNext().getNext());
            keeper.setInfo(aux.getInfo());
            aux.setNext(keeper.getNext());
            this.size--;
            return removedElement;

        } catch (NullPointerException e) {
            throw new NullPointerException("El objeto a eliminar no existe en la lista");

        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            Node<T> aux = header;
            for (int i = 0; aux != null; i++) {
                if (aux.getInfo().equals(o)) {
                    return i;
                }
                aux = aux.getNext();
            }
            throw new NullPointerException("No está en la lista pibe anda a estudiar");

        } catch (NullPointerException e) {
            throw new NullPointerException("No está en la lista pibe anda a estudiar");
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            Node<T> aux = header;
            int position = -1;
            for (int i = 0; aux != null; i++) {
                if (aux.getInfo().equals(o)) {
                    position = i;
                }
                aux = aux.getNext();
            }
            if (position == -1) {
                throw new NullPointerException("No está en la lista pibe anda a estudiar");
            }
            return position;

        } catch (NullPointerException e) {
            throw new NullPointerException("No está en la lista pibe anda a estudiar");
        }
    }

    private class ListIteratorUptc implements ListIterator<T> {

        Node<T> aux = header;
        int index = -1;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay un elemento siguiente del mismo");
            }
            T info = aux.getInfo();
            aux = aux.getNext();
            index++;
            return info;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
        }

        @Override
        public T previous() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previous'");
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }

        @Override
        public void set(T e) {
            Node<T> aux = findNode(index);
            if (aux != null) {
                aux.setInfo(e);
            }

        }

        @Override
        public void add(T e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }

    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIteratorUptc();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    // New ones
    public Node<T> findNode(int index) {
        try {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("El indice excede el tamaño de la lista" + index);
            }
            Node<T> aux = header;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux;
        } catch (NullPointerException e) {
            throw new NullPointerException("El elemento no existe en la lista" + e.getMessage());
        }
    }

    public Node<T> findNode(Object o) {
        try {
            Node<T> aux = header;
            for (int i = 0; i < this.size; i++) {
                if (aux.getInfo().equals(o)) {
                    return aux;
                }
            }
            throw new NullPointerException("El elemento no existe en la lista");
        } catch (NullPointerException e) {
            throw new NullPointerException("El elemento no existe en la lista");
        }
    }

}