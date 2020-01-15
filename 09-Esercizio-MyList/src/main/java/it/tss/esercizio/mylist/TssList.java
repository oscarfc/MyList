/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.mylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tss
 * @param <T>
 */
public class TssList<T> implements List<T> {

    private T[] list = (T[]) new Object[0];

    public TssList() {

    }

    public TssList(T[] list) {
        this.list = Arrays.copyOf(list, list.length);
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object p) {
        for (T el : list) {
            if (el.equals(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new TssIterator<>(Arrays.copyOf(list, list.length));
    }

    // algoritmo
    @Override
    public Object[] toArray() {
        Object[] result = new Object[list.length];
        System.arraycopy(list, 0, result, 0, list.length);
        return result;
    }

    //algoritmo
    @Override
    public <T> T[] toArray(T[] p) {
        System.arraycopy(list, 0, p, 0, list.length);
        return p;
    }

    //algoritmo
    @Override
    public boolean add(T p) {
        //T[] tmp = new T[list.length +1]; array generic creation 
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = p;
        return true;
    }

    //algoritmo
    @Override
    public boolean remove(Object p) {
        List<T> tmp = Arrays.asList(list);
        boolean result = tmp.remove(p);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public boolean containsAll(Collection<?> arg0) {
        return Arrays.asList(list).containsAll(arg0);
    }

    //algoritmo
    @Override
    public boolean addAll(Collection<? extends T> arg0) {
        List<T> tmp = Arrays.asList(list);
        boolean result = tmp.addAll(arg0);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public boolean addAll(int arg0, Collection<? extends T> arg1) {
        List<T> tmp = Arrays.asList(list);
        boolean result = tmp.addAll(arg0, arg1);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public boolean removeAll(Collection<?> arg0) {
        List<T> tmp = Arrays.asList(list);
        boolean result = tmp.removeAll(arg0);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public boolean retainAll(Collection<?> arg0) {
        List<T> tmp = Arrays.asList(list);
        boolean result = tmp.retainAll(arg0);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public void clear() {
        List<T> tmp = Arrays.asList(list);
        tmp.clear();
        list = tmp.toArray(list);
    }

    @Override
    public T get(int idx) {
        return list[idx];
    }

    @Override
    public T set(int idx, T p) {
        T result = list[idx];
        list[idx] = p;
        return result;
    }

    //algoritmo
    @Override
    public void add(int idx, T arg1) {
        List<T> tmp = Arrays.asList(list);
        tmp.add(idx, arg1);
        list = tmp.toArray(list);
    }

    //algoritmo
    @Override
    public T remove(int arg0) {
        List<T> tmp = Arrays.asList(list);
        T result = tmp.remove(arg0);
        list = tmp.toArray(list);
        return result;
    }

    //algoritmo
    @Override
    public int indexOf(Object arg0) {
        return Arrays.asList(list).indexOf(arg0);
    }

    //algoritmo
    @Override
    public int lastIndexOf(Object arg0) {
        return Arrays.asList(list).lastIndexOf(arg0);
    }

    @Override
    public ListIterator<T> listIterator() {
        return new TssListIterator<>(Arrays.copyOf(list, list.length));
    }

    @Override
    public ListIterator<T> listIterator(int idx) {
        return new TssListIterator<>(Arrays.copyOf(list, list.length),idx);
    }

    //algoritmo
    @Override
    public List<T> subList(int arg0, int arg1) {
        return Arrays.asList(list).subList(arg0, arg1);
    }

    @Override
    public String toString() {
        return Arrays.asList(list).toString();
    }

    private class TssIterator<T> implements Iterator<T> {

        private int idx = 0;
        private final T[] data;

        public TssIterator(T[] data) {
            this.data = data;
        }

        @Override
        public boolean hasNext() {
            return idx < data.length;
        }

        @Override
        public T next() {
            return data[idx++];
        }

    }

    private class TssListIterator<T> implements ListIterator<T> {

        private int idx;
        private final T[] data;

        public TssListIterator(T[] data) {
            this(data, 0);
        }

        public TssListIterator(T[] data, int idx) {
            this.data = data;
            this.idx = idx;
        }

        @Override
        public boolean hasNext() {
            return idx < data.length;
        }

        @Override
        public T next() {
            return data[idx++];
        }

        @Override
        public boolean hasPrevious() {
            return idx >= 0;
        }

        @Override
        public T previous() {
            return data[idx--];
        }

        @Override
        public int nextIndex() {
            return idx < data.length ? idx : data.length;
        }

        @Override
        public int previousIndex() {
            return idx > 0 ? idx : -1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(T arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(T arg0) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}