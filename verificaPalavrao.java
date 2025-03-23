//Sistema que implementa a análise de uma lista recebida pelo console, verificando a existencia de palavras inadequadas.

//Exemplo de entra: "Palavrao e palavrao são palavras que nao devem ser usadas por crianças" (entenda o termo <(P)palavrao como um xingamento qualquer).

public class Utilidades{
    public String leitor(){
        Scanner console = new Scanner(System.in);
        String entrada = console.nextLine();
        console.close();
        return entrada;
    }
    List<String> palavroes = Auxiliar.listaPalavroes();  //considere auxiliar uma classe extra, que possui o metodo listaPalavroes que devolve as palavras que devem ser moderadas.
    public boolean moderar(String entrada){
        String entradaLC = entrada.toLowerCase();
        List<String> aux = new ArrayList<String>(Arrays.asList(entradaLC.split(" ")));
        for(String palavrao: palavroes){
            if(aux.contains(palavrao)){
                return true; 
            }
        }
        return false;
    }
}
