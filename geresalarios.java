//codigo que necessita de verificação 

public class Funcionarios {
    private String nome;
    private double salario;
    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }
    public String getNome(){
        return nome;
    }
    public double getSalário(){
        return salario;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setSalario(double salario){
        this.salario=salario;
    }
}

public class Utils{
    public static Funcionarios[] parseFuncionarios(List dados){
        Funcionarios[] funcionarios = new Funcionarios[dados.size()];
        for(int i=0;i<dados.size();i++){
            String[] aux= dados.get(i).split("#");
            Funcionarios auxF = new Funcionario(aux[0],Double.parseDouble(aux[1]));
            funcionarios[i] = auxF;
        }    
        return funcionarios;
    }
    public static double calcularMediaSalarios(Funcionario[] funcionarios){
        double soma = 0;
        for (int i=0;i<funcionarios.lenght;i++){
            soma +=  funcionarios[i].getSalário();
        }
        return soma/funcionarios.length;
    }
}

public class ProgramaPrincipal extends Utils {
    public static void main(String[] args){
        List<Funcionarios> receptor = Utils.getFuncionarios();
        Funcionarios[] receptorSegundo = Utils.parseFuncionarios(receptor);
        System.out.println(Utils.calcularMediaSalarios(receptorSegundo));
    }
}
