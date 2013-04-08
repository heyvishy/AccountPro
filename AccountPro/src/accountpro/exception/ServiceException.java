package accountpro.exception;

public class ServiceException extends Exception{

    public ServiceException(String exc)
    {
        super(exc);
    }
    public String getMessage()
    {
        return super.getMessage();
    }
}