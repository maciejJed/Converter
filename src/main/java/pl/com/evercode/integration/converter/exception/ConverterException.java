package pl.com.evercode.integration.converter.exception;

/**
 * Created by macx on 12.09.16.
 */
public class ConverterException extends Exception{

    private static final long serialVersionUID = 1L;

    public ConverterException(){

    }

    public ConverterException(ExceptionMessages message){
        super(message.name());
    }

    public ConverterException(ExceptionMessages message, Throwable cause){
        super(message.name(), cause);
    }

}
