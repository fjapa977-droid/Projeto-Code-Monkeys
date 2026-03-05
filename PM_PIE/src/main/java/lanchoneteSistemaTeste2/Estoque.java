package lanchoneteSistemaTeste2;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Integer,Ingredientes > ingredientes = new HashMap<>();

    public void adicionarIngrediente(int id, String nome, int quantidade, double quilogramas){
        Ingredientes novo = new Ingredientes(id, nome, quantidade, quilogramas);

        ingredientes.put(id,novo);
    }

    public Ingredientes buscarIngrediente(int id){
        return ingredientes.get(id);
    }
    public void removerIngrediente(int id){
        ingredientes.remove(id);
    }

    public Ingredientes atualizarQuantidade(int id,int novaQuantidade){
        Ingredientes ingrediente = ingredientes.get(id);

        if(ingrediente != null){
            ingrediente.setQuantidade(novaQuantidade);
        }
        return ingrediente;
    }
}

