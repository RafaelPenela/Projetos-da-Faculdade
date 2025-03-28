//código para estudo que usa exceptions de forma simplista


public class CriaturaMarinha{
    private String tag;
    private String nomeEspecie;
    private int profundidadeEncontrada;
    public CriaturaMarinha(String tag, String nomeEspecie, int profundidadeEncontrada){
        this.tag=tag;
        this.nomeEspecie=nomeEspecie;
        this.profundidadeEncontrada=profundidadeEncontrada;
    }
    public String getTag(){
        return tag;
    }
    public String getNomeEspecie(){
        return nomeEspecie;
    }
    public int getProfundidadeEncontrada(){
        return profundidadeEncontrada;
    }
    public void setTag(String tag){
        this.tag=tag;
    }
    public void setNomeEspecie(String nomeEspecie){
        this.nomeEspecie=nomeEspecie;
    }
    public void setProfundidadeEncontrada(int profundidadeEncontrada){
        this.profundidadeEncontrada=profundidadeEncontrada;
    }
    public String toString(){
        return tag + nomeEspecie + profundidadeEncontrada;
    }

}

public class Utils{
    public Map<CriaturaMarinha, Integer> retornaDados(Set<String> conjuntoCriaturas){
        Map<CriaturaMarinha, Integer> mapa = new HashMap<>();
        for(String entrada : conjuntoCriaturas){
            String[] entradas = entrada.split("#");
            try{
                if (entradas.length < 4) {
                    throw new FormatoIncorretoException("Formato incorreto: [" + entrada + "]");
                }
                CriaturaMarinha criatura = new CriaturaMarinha(entradas[1], entradas[2], Integer.parseInt(entradas[3]));
                mapa.put(criatura, Integer.parseInt(entradas[3]));
            }
            catch(Exception e){
                throw new FormatoIncorretoException("FormatoIncorretoException: O formato da String [" + entrada + "] está incorreto.");
            }
        }
        return mapa;
    }
}

public class FormatoIncorretoException extends Exception{
    public FormatoIncorretoException(String mensagem){
        super(mensagem);
    }

} 
