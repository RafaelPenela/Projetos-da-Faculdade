//código que necessita de testes

public interface Ligavel{
    void ligavel();
}

public class Produto {
    private String id;
    private String cor;
    private double preco;
    public Produto(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public void setId(String id){
        this.id=id;
    }
    public void SetNome(String nome){
        this.nome=nome;
    }
    public void setPreco(double preco){
        this.preco =preco;
    }
    public toString(){
        return id + cor + preco;
    }
}

public class Televisao extends Produto implements Ligavel{
    public Televisao(String id){
        super(id);
    }
    public void ligavel(){
        System.out.println("tv esta ligada");
    }
}

public class  Tapete extends Produto{
    public Tapete(String id){
        super(id);
    }
}

public class ProgramaPrincipal{
    public static List filtrarLigaveis(List objetos){
        List produtos = new ArrayList();
        for(int i=0;i<objetos.size();i++){
            if(objetos.get(i) instanceof Televisao){
                produtos.add(objetos.get(i));
            }
        }
        return produtos;
    }
    public void media(List fim){
        double somatorio= 0;
        for (int i=0;i<fim.size();i++){
            somatorio += fim.get(i).getPreco();
        }
        return somatorio/fim.size();
    }
    public static void main(String[] args){
        List a = Utils.getLista();
        List filtrada=Utils.filtrarLigaveis(a);
        System.out.println(media(filtrada));
    }
}
