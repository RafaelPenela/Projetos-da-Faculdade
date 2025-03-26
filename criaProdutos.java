//código que considera a pre implementação do objeto Utils e seus métodos. Por se tratar de um código para estudo de estruturas, ele é pouco polido.

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
    public String getCor(){
        return cor;
    }
    public double getPreco(){
        return preco;
    }
    public void setId(String id){
        this.id=id;
    }
    public void SetCor(String cor){
        this.cor=cor;
    }
    public void setPreco(double preco){
        this.preco =preco;
    }
    public String toString(){
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
    public static double media(List fim){
        double somatorio= 0;
        for (int i=0;i<fim.size();i++){
            somatorio += fim.get(i).getPreco();
        }
        return somatorio/fim.size();
    }
    public static void main(String[] args){
        List a = Utils.getLista();
        List filtrada=ProgramaPrincipal.filtrarLigaveis(a);
        System.out.println(media(filtrada));
    }
}
