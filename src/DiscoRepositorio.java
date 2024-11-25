import java.util.ArrayList;
import java.util.List;

public class DiscoRepositorio implements ICatalogo<Disco> {
    private List<Disco> discos = new ArrayList<>();

    
    @Override
    public void adicionar(Disco disco) {
        if (disco != null) {
            discos.add(disco);
            System.out.println("Disco adicionado com sucesso.");
        } else {
            System.out.println("Erro: disco não pode ser nulo.");
        }
    }

    
    @Override
    public void remover(Disco disco) {
        if (disco != null && discos.contains(disco)) {
            discos.remove(disco);
            System.out.println("Disco removido com sucesso.");
        } else {
            System.out.println("Erro: disco não encontrado.");
        }
    }

    
    @Override
    public List<Disco> listar() {
        return discos;
    }

    
    public Disco buscarPorTitulo(String titulo) {
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                return disco;
            }
        }
        return null;
    }
}