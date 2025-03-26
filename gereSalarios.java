public class Funcionarios {
    private String nome;
    private double salario;
    public Funcionarios(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }
    public String getNome(){
        return nome;
    }
    public double getSalario(){
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
        for (int i=0;i<funcionarios.length;i++){
            soma +=  funcionarios[i].getSalario();
        }
        return soma/funcionarios.length;
    }
    public static List getFuncionarios() {
        List<String> funcionarios = new ArrayList<>();
        funcionarios.add("João#2500.00");
        funcionarios.add("Maria#3000.00");
        funcionarios.add("Pedro#2800.00");
        return funcionarios;
    }
}

public class ProgramaPrincipal {
    public static void main(String[] args){
        List<Funcionarios> receptor = Utils.getFuncionarios();
        Funcionarios[] receptorSegundo = Utils.parseFuncionarios(receptor);
        System.out.println(Utils.calcularMediaSalarios(receptorSegundo));
    }
}
