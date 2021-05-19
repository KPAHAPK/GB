package ru.geekbrains.courses.kpah;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainClass2Test {
    private MainClass2 mainClass2;

    @CsvSource({
            "2, 1, 4",
            "1, 2, 4",
            "1, 4, 2",
            "1, 4, 1"
    })

    @ParameterizedTest
    public void massTestAdd(int a, int b, int c){
        mainClass2 = new MainClass2();
        int[] array = {a, b, c};
        Assert.assertTrue(mainClass2.checkArray(array));
    }

}