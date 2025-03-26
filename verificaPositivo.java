//código para fins de estudo. A versão mais otimizada trataria a excessão na função que chamasse o método e não necessitaria de um retorno alternativa para caso de erro;

public class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String string){
        super(string);
    }
}

public class MeuNumero  {
    public static double media(String string) throws NumeroNegativoException {
        String[] valores = string.split("#");
        double somatorio = 0;
        try{
            for(int i=0;i<valores.length;i++){
                int v = Integer.parseInt(valores[i]);
                if( v <0){
                    throw  new NumeroNegativoException("erro");
                } else {
                    somatorio += v;
                }
            }
            return somatorio/valores.length;
        } catch (NumeroNegativoException e) {
            System.out.println("Numero errado");
            return -1;
        }
    }
}
