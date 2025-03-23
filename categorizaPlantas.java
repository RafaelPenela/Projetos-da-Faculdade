import java.util.ArrayList;

public class Planta{
    private String nome;
    private String id; 
    private double tamanho;
    public Planta(String id){
        this.id=id;
    }
    public String getNome(){
        return nome;
    }
    public String getId(){
        return id;
    }
    public double getTamanho(){
        return tamanho;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }
    public String toString(){
        return "ID: " + id + ", Nome: " + nome + ", Tamanho: " + tamanho + "cm";
    }
    public boolean equals(Object objeto){
        if(!(objeto instanceof Planta)) return false;
        Planta planta = (Planta) objeto;
        return this.getId().equals(planta.getId());
    }
}

public class Briofita extends Planta{
    public Briofita(String id){
        super(id);
    }
    public String toString(){
        return "[Briofita] " + super.toString();
    }
}

public class Pteridofita extends Planta{
    public Pteridofita(String id){
        super(id);
    }
    public String toString(){
        return "[Pteridofita] " + super.toString();
    }
}

public class Utils{
    public static boolean existe(ArrayList<Planta> lista, Planta planta){
        return lista.contains(planta);
    }
    public static Planta[] ordenaTamanho(List lista){
        Planta[] arrayPlantas = new Planta[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arrayPlantas[i] = (Planta) lista.get(i);
        }
        for(int i=0;i<(lista.size()-1); i++){
            for (int j=i+1;j<lista.size();j++){
                if(arrayPlantas[j].getTamanho() > arrayPlantas[i].getTamanho() ){
                    Planta aux = arrayPlantas[i];
                    arrayPlantas[i] = arrayPlantas[j];
                    arrayPlantas[j] = aux;
                }
            }
        }
        return arrayPlantas;
    }
}
