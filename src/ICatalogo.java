import java.util.List;

public interface ICatalogo<T> {
    void adicionar (T item);
    void remover (T item);
    List<T> listar();
}