package ru.ilya_polyakov.data_pool.datapool_initializers.exceptions;

import java.io.IOException;

public class InitializationException extends Exception {
    public InitializationException(IOException e) {
        super(e);
    }
}
