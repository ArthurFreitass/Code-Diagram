package SENAISystem.model.exceptions;

public class DomainException  extends RuntimeException {

    private static final long serialVersioUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }
}
