/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.mylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tss
 * @param <T>
 */
public class TssList<T> implements List<T> {

    private T[] list ;

    public TssList() {
        list = (T[]) new Object[0];
    }

    public TssList(T[] list) {
        this.list = (T[]) new Object[list.length];
        for (int i = 0; i < this.list.length; i++) {
            this.list[i] = list[i];            
        }
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
        checkIfIsNull(p);
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
        for (int i = 0; i < list.length; i++) {
            result[i] = list[i];
        }
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
        checkIfIsNull(p);
        T[] tmp;
        tmp = (T[]) new Object[list.length + 1];
        /*array generic creation*/
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }
        tmp[list.length] = p;
        list = tmp;
//        list = Arrays.copyOf(list, list.length + 1);
//        list[list.length - 1] = p;
        return true;
    }

    //algoritmo
    @Override
    public boolean remove(Object p) {
        checkIfIsNull(p);
        int pos = indexOf(p);
        if (pos == -1) {
            return false;
        }
        T[] tmp;
        tmp = (T[]) new Object[list.length - 1];
        /*array generic creation*/
        for (int i = 0; i < pos; i++) {
            tmp[i] = list[i];
        }
        for (int i = pos; i < tmp.length; i++) {
            tmp[i] = list[i + 1];

        }
        list = tmp;

//        List<T> tmp = Arrays.asList(list);
//        boolean result = tmp.remove(p);
//        list = tmp.toArray(list);
        return true;
    }

    //algoritmo
    @Override
    public boolean containsAll(Collection<?> arg0) {
        checkIfIsNull(arg0);
        return Arrays.asList(list).containsAll(arg0);
    }

    //algoritmo
    @Override
    public boolean addAll(Collection<? extends T> arg0) {
        checkIfIsNull(arg0);
        T[] tmp;
        tmp = (T[]) new Object[list.length + arg0.size()];
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }
        T[] a = (T[]) arg0.toArray();
        for (int i = 0; i < a.length; i++) {
            checkIfIsNull(a[i]);
            tmp[i + list.length] = (T) a[i];
        }
        list = tmp;
        return true;
    }

    //algoritmo
    @Override
    public boolean addAll(int arg0, Collection<? extends T> arg1) {
        checkIfIsOutOfBound(arg0);
        checkIfIsNull(arg1);
        T[] tmp;
        tmp = (T[]) new Object[list.length + arg1.size()];
        for (int i = 0; i < arg0; i++) {
            tmp[i] = list[i];
        }
        T[] a = (T[]) arg1.toArray();
        for (int i = 0; i < a.length; i++) {
            checkIfIsNull(a[i]);
            tmp[i + arg0] = a[i];
        }
        for (int i = arg0; i < list.length; i++) {
            tmp[i + a.length] = list[i];
        }
        list = tmp;
        return true;
    }

    //algoritmo
    @Override
    public boolean removeAll(Collection<?> arg0) {
        checkIfIsNull(arg0);
        T[] tmp = backupList();
        for (Object ob : arg0) {
            checkIfIsNull(ob);
            if (!this.remove((T) ob)) {
                list = tmp;
                return false;
            }
        }
        return true;
//        List<T> tmp = new ArrayList<>( Arrays.asList(list));
//        boolean result = tmp.removeAll(arg0);
//        list = tmp.toArray(list);
//        return result;
    }

    //algoritmo
    @Override
    public boolean retainAll(Collection<?> arg0) {
        checkIfIsNull(arg0);
        T[] tmp;
        tmp = (T[]) new Object[list.length];
        boolean copia;
        int i = 0;
        for (T el : list) {
            copia = false;
            for (Object ob : arg0) {
                if (el.equals(ob)) {
                    copia = true;
                    break;
                }
            }
            if (copia) {
                tmp[i++] = el;
            } else {
                return false;
            }
        }
        list = (T[]) new Object[i];
        for (int j = 0; j < i; j++) {
            list[j] = tmp[j];
        }
        return true;
    }

    //algoritmo
    @Override
    public void clear() {
        list = (T[]) new Object[0];
    }

    @Override
    public T get(int idx) {
        checkIfIsOutOfBound(idx);
        return list[idx];
    }

    @Override
    public T set(int idx, T p) {
        checkIfIsOutOfBound(idx);
        checkIfIsNull(p);
        T result = list[idx];
        list[idx] = p;
        return result;
    }

    //algoritmo
    @Override
    public void add(int idx, T arg1) {
        checkIfIsOutOfBound(idx);
        checkIfIsNull(arg1);
        T[] tmp;
        tmp = (T[]) new Object[list.length + 1];
        for (int i = 0; i < idx; i++) {
            tmp[i] = list[i];
        }
        tmp[idx] = (T) arg1;
        for (int i = idx; i < list.length; i++) {
            tmp[i + 1] = list[i];
        }
        list = tmp;
    }

    //algoritmo
    @Override
    public T remove(int arg0) {
        checkIfIsOutOfBound(arg0);
        T[] tmp;
        T t;
        tmp = (T[]) new Object[list.length - 1];
        for (int i = 0; i < arg0; i++) {
            tmp[i] = list[i];
        }
        t = list[arg0];
        for (int i = arg0; i < tmp.length; i++) {
            tmp[i] = list[i + 1];
        }
        list = tmp;
        return t;
    }

    //algoritmo
    @Override
    public int indexOf(Object arg0) {
        checkIfIsNull(arg0);
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(arg0)) {
                return i;
            }
        }
        return -1;
    }

    //algoritmo
    @Override
    public int lastIndexOf(Object arg0) {
        checkIfIsNull(arg0);
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(arg0)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new TssListIterator<>(Arrays.copyOf(list, list.length));
    }

    @Override
    public ListIterator<T> listIterator(int idx
    ) {
        return new TssListIterator<>(Arrays.copyOf(list, list.length), idx);
    }

    //algoritmo
    @Override
    public List<T> subList(int arg0, int arg1) {
        checkIfIsOutOfBound(arg0);
        checkIfIsOutOfBound(arg1);
        if (arg1 < arg0) {
            throw new IndexOutOfBoundsException();
        }
        List<T> l = new ArrayList<>(arg1 - arg0);
        for (int i = arg0; i < arg1; i++) {
            l.add(list[i]);
        }
        return l;
    }

    @Override
    public String toString() {
        String ret = "[ ";
        for (int i = 0; i < list.length - 1; i++) {
            ret += list[i].toString() + ", ";
        }
        ret += (list.length == 0 ? " " : list[list.length - 1].toString() + " ") + "]";
        return ret;
    }

    private void checkIfIsNull(Collection<? extends T> arg0) {
        if (arg0 == null) {
            throw new NullPointerException();
        }
    }

    private void checkIfIsNull(Object ob) {
        if (ob == null) {
            throw new NullPointerException();
        }
    }

    private void checkIfIsOutOfBound(int arg0) {
        if (arg0 < 0 || arg0 > list.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    private T[] backupList() {
        T[] ret = (T[]) new Object[list.length];

        for (int i = 0; i < list.length; i++) {
            ret[i] = list[i];
        }
        return ret;
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
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
