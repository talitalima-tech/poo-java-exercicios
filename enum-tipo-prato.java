enum TipoPrato {
    ENTRADA(10),
    PRATO_PRINCIPAL(30),
    SOBREMESA(15);
    
    public int tempo;
    
    TipoPrato(int tempo) {
        this.tempo = tempo;
    }
    
    public int getTempo() {
        return tempo;
    }
    
    public String toString() {
        return name();
    }
}

class Prato {
    private String nome;
    private TipoPrato tipo;
    private int tempoPreparo;
    
    Prato (String nome, TipoPrato tipo) {
        if (nome != null && tipo != null){
            this.nome = nome;
            this.tipo = tipo;
            this.tempoPreparo = tipo.getTempo();
        }
    }
    
    private void setNome(String nome) {
        if (nome != null) this.nome = nome;
    }
    
    private void setTipo(TipoPrato tipo) {
        if (tipo != null) this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public TipoPrato getTipo() {
        return tipo;
    }
    
    public int getTempoPreparo(){
        return tempoPreparo;
    }
    
    public String toString() {
        return String.format("Prato: %s, Tipo: %s, Tempo de Preparo: %d minutos", 
        getNome(), getTipo().toString(), getTempoPreparo() );
    }
}