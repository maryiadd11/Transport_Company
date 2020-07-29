package exceptions;

public class NoCityException extends Exception{

    public String message () {
        return "К сожалению данного города нет в списке";
    }

}
