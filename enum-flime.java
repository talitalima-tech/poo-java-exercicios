enum Genero{
    COMEDIA(1, "Comedia"),
    DRAMA(2, "Drama"),
    TERROR(3, "Terror"),
    ACAO(4, "Acao"),
    FICCAO(5, "Ficcao");
    
    private int codigo;
    private String genero;
    
    Genero(int codigo, String genero){
        this.genero = genero;
        this.codigo = codigo;
    }
    public int getValor(){
        return codigo;
    }
    public String getDescricao(){
        return genero;
    }
}


public class Filme{
    private String nome;
    private String descricao;
    private Genero genero;
    
    //genero provavelmente enum
    
    //get e set
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    //
    public Genero getGenero(){
        return genero;
    }
    public String getDescricao(){
        return descricao;
    }
    public int getValor(){
        int valor = genero.getValor();
        return valor;
    }
    //
    
    //metodos a parte
    public float Avaliacao(double nota_publica, double nota_critica){
        if((nota_publica>=0 && nota_critica<=5) && (nota_critica>=0 && nota_critica<=5)){
            if(genero == null){
                return 0.0f;
            }
            double media = (nota_publica + nota_critica)/2;
            float media2 = (float)media;
            return media2;
        }
        return 0.0f;
    }
    public float Avaliacao(double nota_publica){
        if(nota_publica>=0 && nota_publica<=5){
            if(genero == null){
                return 0.0f;
            }
            int codigo = genero.getValor();
            double media = (nota_publica + codigo)/codigo;
            float media2 = (float)media;
            return media2;
        }
        return 0.0f;
    }
}