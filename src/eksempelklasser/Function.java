package eksempelklasser;

@FunctionalInterface
public interface Function<T,R>    // T for argumenttype, R for returtype
{
    R anvend(T t);
}