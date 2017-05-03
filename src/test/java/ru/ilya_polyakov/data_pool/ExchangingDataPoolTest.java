package ru.ilya_polyakov.data_pool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class ExchangingDataPoolTest {

    @Test
    public void add() throws Exception {
        ExchangingDataPool<String> dataPool = new ExchangingDataPool<String>();
        dataPool.add("Value1");
        dataPool.add("Value2");
        dataPool.add("Value3");
    }

    @Test
    public void getNext() throws Exception {
        ExchangingDataPool<String> dataPool = new ExchangingDataPool<String>();
        dataPool.add("Value1");
        dataPool.add("Value2");
        dataPool.add("Value3");
        Assert.assertEquals("Value3", dataPool.getNext());
        Assert.assertEquals("Value2", dataPool.getNext());
        Assert.assertEquals("Value1", dataPool.getNext());
    }

}