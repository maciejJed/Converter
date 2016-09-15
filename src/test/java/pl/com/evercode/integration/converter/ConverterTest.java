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

    private Converter converter;
    private String inputCorrect;
    private String inputDataNoNamePerson;
    private String inputDataWrongFormat;
    private String expectedOKOutput;
    private String inputDataWrongStart;

    @BeforeClass
    public void configure() throws Exception{
        String path = "";
        converter = new ConverterToXmlImpl();
        inputCorrect = getFileInput(path+"inputDataCorrect.txt");
        inputDataNoNamePerson = getFileInput(path+"inputDataNoNamePerson.txt");
        expectedOKOutput = getFileInput(path+"expectedOKOutput.txt");
        inputDataWrongFormat = getFileInput(path+"inputDataWrongFormat.txt");
        inputDataWrongStart = getFileInput(path+"inputDataWrongStart.txt");
    }

    @Test
    public void testConverterOutputCorrect() throws Exception{
        String result = converter.convert(inputCorrect);
        Assert.assertEquals(result, expectedOKOutput);
    }

    @Test(expectedExceptions = ConverterException.class, expectedExceptionsMessageRegExp = "PERSON_MUST_HAVE_NAME_AND_SURNAME")
    public void testConvertedOutputNoNamePerson() throws Exception{
        converter.convert(inputDataNoNamePerson);
    }

    @Test(expectedExceptions = ConverterException.class, expectedExceptionsMessageRegExp = "WRONG_INPUT_FORMAT_EXCEPTION")
    public void testConvertedOutputWrongFormat() throws Exception{
        converter.convert(inputDataWrongFormat);
    }

    @Test(expectedExceptions = ConverterException.class, expectedExceptionsMessageRegExp = "INPUT_MUST_START_WITH_PERSON_ELEMENT")
    public void testConvertedOutputWrongStart() throws Exception{
        converter.convert(inputDataWrongStart);
    }


    private String getFileInput(String path) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while((line = br.readLine()) != null){
            sb.append(line);
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString().trim();
    }
}
