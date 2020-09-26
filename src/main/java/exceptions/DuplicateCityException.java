package exceptions;

public class DuplicateCityException extends Exception {

    private String name;

    public DuplicateCityException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return name + " уже существует";
    }
}
