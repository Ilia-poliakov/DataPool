package ru.ilya_polyakov.data_pool;


import ru.ilya_polyakov.data_pool.datapool_initializers.DataPoolInitializer;
import ru.ilya_polyakov.data_pool.datapool_initializers.exceptions.InitializationException;
import ru.ilya_polyakov.data_pool.data_structures.Stack;
import ru.ilya_polyakov.data_pool.data_structures.TreiberStack;

public class ExchangingDataPool<T> implements DataPool<T> {

    private Stack<T> stack;

    public ExchangingDataPool() {
        this.stack = new TreiberStack<T>();
    }

    public ExchangingDataPool(DataPoolInitializer dataPoolInitializer) throws InitializationException {
        this();
        dataPoolInitializer.init(this);
    }

    @Override
    public void add(T value) {
        stack.push(value);
    }

    @Override
    public T getNext() {
        return stack.pop();
    }

}
