package ru.ilya_polyakov.data_pool.datapool_initializers;

import ru.ilya_polyakov.data_pool.DataPool;
import ru.ilya_polyakov.data_pool.datapool_initializers.exceptions.InitializationException;

public interface DataPoolInitializer {

    public void init(DataPool dataPool) throws InitializationException;
}
