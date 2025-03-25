//codigo em processo de teste e aprimoramento


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
    public Strign toString(){
        return tag + id + profundidadeEncontrada;
    }

}

public class Utils{
    public Map retornaDados(Set conjuntoCriaturas) throws FormatoIncorretoException{
        Map mapa = new hashMap();
        for(int i=0;i<conjuntoCriaturas.size();i++){
            String[] entradas = conjuntoCriaturas.get(i).split("#");
            try{
                CriaturaMarinha criatura = new CriaturaMarinha(entradas[1], entradas[2], Integer.parseInt(entradas[3]));
                mapa.put(criatura, Integer.parseInt(entrada[3]));
            }
            catch{
                throw new FormatoIncorretoException("FormatoIncorretoException: O
formato da String ["+ conjuntoCriaturas.get(i) +"] está incorreto.");
            }
        }
    }
}

public class FormatoIncorretoException extends Exception{
    public FormatoIncorretoException(){
        super();
    }

} 
