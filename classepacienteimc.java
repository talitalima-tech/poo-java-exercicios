public class Paciente{
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        if (idade>0 && idade <= 120){
            this.idade = idade;
        }
    }
    
    public void setAltura(float altura){
        if (altura>0 && altura <=2.51){
            this.altura = altura;
        }
    }
    
    public void setPeso(float peso){
        if (peso>0 && peso <=635){
            this.peso = peso;
        }
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public float getAltura(){
        return altura;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public float calcularIMC(){
        if (idade >= 18){
            return peso/(altura*altura);
        } else {
            return 0.0f;
        }
    }
    
    public String classificarIMC() {
        float imc = calcularIMC();
        if (imc < 18.5f) {
            return "(Abaixo do Normal)";
        } else if (imc >= 18.5f && imc <= 24.9f) {
            return "(Normal)";
        } else if (imc >= 25.0f && imc <= 29.9f) {
            return "(Sobrepeso)";
        } else if (imc >= 30.0f && imc <= 34.9f) {
            return "(Obesidade grau I)";
        } else if (imc >= 35.0f && imc <= 39.9f) {
            return "(Obesidade grau II)";
        } else {
            return "(Obesidade grau III)";
        }
    }
    
    public String gerarRelatorio() {
        if(nome == null || idade <= 0 || altura <= 0 || idade <= 0){
            return "Entre com todos os dados do paciente!";
        } else {
            float imc = calcularIMC();
            return getNome() + ", " + getIdade() + " anos, " + getAltura() + "m, " + getPeso() + "kg\n" + "IMC: " + imc + " " + classificarIMC();
        }
    }
}

public class TESTE{
  public static void main(String[] args){
    
    System.out.println();
  }
}