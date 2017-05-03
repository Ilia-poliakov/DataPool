package ru.ilya_polyakov.data_pool.datapool_initializers;

import ru.ilya_polyakov.data_pool.DataPool;
import ru.ilya_polyakov.data_pool.datapool_initializers.exceptions.InitializationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataPoolInitializerFromTextFile implements DataPoolInitializer {

    private final String filePath;

    public DataPoolInitializerFromTextFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void init(DataPool dataPool) throws InitializationException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                dataPool.add(line);
            }
        } catch (IOException ex) {
            throw new InitializationException(ex);
        }
    }
}
