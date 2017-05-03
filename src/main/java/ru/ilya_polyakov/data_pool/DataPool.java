package ru.ilya_polyakov.data_pool;


public interface DataPool<T> {

    public void add(T value);

    public T getNext();

}
