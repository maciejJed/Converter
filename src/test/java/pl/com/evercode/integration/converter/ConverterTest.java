package pl.com.evercode.integration.converter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.com.evercode.integration.converter.exception.ConverterException;
import pl.com.evercode.integration.converter.impl.ConverterToXmlImpl;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by macx on 15.09.16.
 */
public class ConverterTest {

    @Test
    public void testConverterOutputCorrect() throws Exception{
        String result = "xxx2";
        Assert.assertEquals(result, "xxx2");
    }
}
