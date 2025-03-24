//código com erros, que será concertado

import java.util.Iterator;

public abstract class Livro{
    private String nome;
    private String autor;
    private int ano;
    private String ISBN;
    public Livro(String ISBN){
        this.ISBN = ISBN;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean equals(Object objeto) {
        if (objeto instanceof Livro) {
            Livro livro = (Livro) objeto;
            return this.getISBN().equals(livro.getISBN());
        }
        return false;
    }
    public String toString(){
    return nome+" "+ano+" "+autor+" "+ISBN;
    }
}

public class LivroDeLivraria extends Livro{
    private boolean vendido;
    public LivroDeLivraria(String ISBN, boolean vendido){
        super(ISBN);
        this.vendido = vendido;
    }
    public boolean getVendido(){
        return vendido;
    }
    public void setVendido(boolean vendido){
        this.vendido = vendido;
    }
    public String toString(){  
        return super.toString() + "vendido: "+vendido;
    }
}

public class LivroDeBiblioteca extends Livro{
    private boolean alugado;
    public LivroDeBiblioteca(String ISBN, boolean alugado){
        super(ISBN);
        this.alugado = alugado ;
    }
     public boolean getAlugado(){
        return alugado;
    }
    public void setAlugado(boolean alugado){
        this.alugado = alugado;
    }
    public String toString(){  
        return super.toString() + "alugado: "+alugado;
    }
}

public class Instituicao{
    private List<Livro> listaDeLivros;
    public Instituicao(){
        this.listaDeLivros = new ArrayList<Livro>();
    }
    public void insereLivro(Livro livro){
        this.getListaDeLivros().add(livro);
    }
    public List<Livro> retornaLista (){
        return listaDeLivros;
    }
}

public class Principal {
    public static LivroDeBiblioteca livroA = new LivroDeBiblioteca("1A", true) ;
    public static LivroDeBiblioteca livroB = new LivroDeBiblioteca("2A", false) ;
    public static LivroDeLivraria livroC = new LivroDeLivraria("1B", true)  ;
    public static LivroDeLivraria livroD = new LivroDeLivraria("2B", false) ;
    public static void main(String[] args){
        Instituicao instituicao = new Instituicao();
        instituicao.retornaLista();
        instituicao.insereLivro(livroA);
        instituicao.insereLivro(livroB);
        instituicao.insereLivro(livroC);
        instituicao.insereLivro(livroD);
    }
    public void imprimeRelatorioGeral(List<Livro> listaDeLivros){
        Iterator<Livro> i = listaDeLivros.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
            }
        }
    } 
    public void recebeEntrada(List<Livro> listaDeLivros){
        Scanner console = new Scanner(System.in);
        System.out.println("Qual o ISBN do livro a ser consultado?");
        String entrada = console.nextLine();
        console.close();
        Livro aux = new LivroDeLivraria();
        aux.setISBN(entrada);
        if(listaDeLivros.contains(aux)){
            int i = listaDeLivros.indexOf(aux);
            Livro l = listaDeLivros.get(i);
            System.out.println(l);
        }
    }
}
