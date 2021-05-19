package ru.geekbrains.courses.kpah;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainClassTest {
    private MainClass mainClass;


    @Before
    public void setup() {
        mainClass = new MainClass();
    }

    @Test
    public void test01(){
        Integer[] array = {1, 2, 3, 5, 6};
        Assert.assertThrows(RuntimeException.class, () -> mainClass.checkArray(array));
    }

    @Test
    public void test02(){
        Integer[] array ={1, 3, 4, 5, 6};
        int[] resultArray = {5, 6};
        Assert.assertEquals(Arrays.toString(resultArray), Arrays.toString(mainClass.getDigitsAfterLastFourAndCreateNewArray(array)));
    }

    @Test
    public void test03(){
        Integer[] array ={1, 3, 4};
        int[] resultArray = {};
        Assert.assertEquals(Arrays.toString(resultArray), Arrays.toString(mainClass.getDigitsAfterLastFourAndCreateNewArray(array)));
    }

}