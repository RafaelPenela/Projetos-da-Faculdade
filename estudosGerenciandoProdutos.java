public interface Ligavel{
    void ligar();
}

public class Produto {

    private String id;
    private String cor;
    private double preco;

    public Produto(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean equals(Object objeto){
        if(objeto instanceof Produto){
            Produto produto = (Produto) objeto;
            return this.getId().equals(produto.getId());
        }
        return false;
    }
    public String toString(){
        return "Cor: " + cor + ", ID: " + id + ", Preço: " + preco;
    }
}


public class Utils{
    public static boolean existe (List<Produto> x,Produto y){
        return x.contains(y);
    }
    public static List<Produto> getLista() { 
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("123"));
        lista.add(new Produto("456"));
        lista.add(new Produto("789"));
        return lista;
    }
}

public class Tapete extends Produto{
    public Tapete(String id) {
        super(id);
    }
}

public class TV extends Produto implements Ligavel{
     public TV(String id) {
        super(id);
    }
    public void ligar(){
        System.out.println("Ligou");
    }
}
         
                    
public class VerificaProduto {
    public void verifica(){
        Scanner scanner = new Scanner(System.in);
        String escolhido = scanner.nextLine();
        scanner.close();
        List<Produto> lista = Utils.getLista();
        for (Produto produto : lista) {
             if (produto.getId().equals(escolhido)) {
                 System.out.println(produto);
                 return;
             }
        }
        System.out.println("Produto não encontrado.");
        }
    }
}               

public class Principal{
    public Map<String, Produto> transformaLista(List<Produto> lista){
        Map<String, Produto> mapa = new HashMap<>();
        for(Produto produto : lista){
            mapa.put(produto.getId(), produto);
        }
        return mapa;
    }

    public Produto[] transformaMap (Map<String, Produto> m){
        return m.values().toArray(new Produto[m.size()]);
    }
}
