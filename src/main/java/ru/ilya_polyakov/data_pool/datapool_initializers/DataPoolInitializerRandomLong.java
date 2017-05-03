package ru.ilya_polyakov.data_pool.datapool_initializers;

import ru.ilya_polyakov.data_pool.DataPool;
import ru.ilya_polyakov.data_pool.datapool_initializers.exceptions.InitializationException;

import java.util.Random;

public class DataPoolInitializerRandomLong implements DataPoolInitializer {

    private final int valueCount;

    public DataPoolInitializerRandomLong(int valueCount) {
        this.valueCount = valueCount;
    }

    @Override
    public void init(DataPool dataPool) throws InitializationException {
        Random random = new Random();
        for (int i = 0; i < valueCount; i++) {
            dataPool.add(random.nextLong());
        }
    }
}
