//codigo em teste e aprimoramento

public interface Animal{
    void emitirSom();
    void mover();
}

public class Cachorro implements Animal{
    private String nome;
    public Cachorro(String nome){
        this.nome = nome;
    }
    public void emitirSom(){
        System.out.println("Au, Au!");
    }
    public void mover(){
        System.out.println("cachorro correndo!");
    }
}

public class Pato implements Animal {
    private String nome;
    public Pato(String nome){
        this.nome = nome;
    }
    public void setNome(String nome){
        this.nome=nome; 
    }
    public String getNome(){
        return nome;
    }
    public void emitirSom(){
        System.out.println("Quack, Quack!");
    }
    public void mover(){
        System.out.println("Pato nadando!");
    }
}

public class TesteAnimais{
    public static void main (String[] args){
        List<Animal> animais = new ArrayList<Animal>();
        Animal cachorro1 = new Cachorro ("bethoven");
        Animal pato1 = new Pato ("laranjinha");
        animais.add(cachorro1);
        animais.add(pato1); 
        for(int i = 0;i<animais.size();i++){
            if(animais.get(i) instanceof Cachorro){
                Cachorro cachorro = (Cachorro) animais.get(i);
                cachorro.emitirSom();
                cachorro.mover();
            } else {
                Pato pato = (Pato) animais.get(i);
                pato.emitirSom();
                pato.mover();
            }
        }
    }

}
