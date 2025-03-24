//código que necessida de verificações 

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
            for(int i=0;i<valores.lenght;i++){
                int v = Integer.parseInt(valores[i]);
                if( v <0){
                    throw  new NumeroNegativoException("erro");
                } else {
                    somatio += v;
                }
            }
            return somatorio/valores.length;
        } catch (NumeroNegativoException e) {
            System.out.println("Numero errado");
        }
    }
}
