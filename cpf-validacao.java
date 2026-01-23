public class CPF {
    private String nome;
    private String numero;
    private int diaEmissao;
    private int mesEmissao;
    private int anoEmissao;

    public CPF() {}

    public CPF(String numero) {
        setNumero(numero);
    }

    public boolean validarNumero(String numero) {
        if (numero == null || numero.length() != 11 || !numero.matches("\\d{11}")) {
            return false;
        }

        int a = Character.getNumericValue(numero.charAt(0));
        int b = Character.getNumericValue(numero.charAt(1));
        int c = Character.getNumericValue(numero.charAt(2));
        int d = Character.getNumericValue(numero.charAt(3));
        int e = Character.getNumericValue(numero.charAt(4));
        int f = Character.getNumericValue(numero.charAt(5));
        int g = Character.getNumericValue(numero.charAt(6));
        int h = Character.getNumericValue(numero.charAt(7));
        int i = Character.getNumericValue(numero.charAt(8));
        int j = Character.getNumericValue(numero.charAt(9));
        int k = Character.getNumericValue(numero.charAt(10));

        int soma1 = a * 10 + b * 9 + c * 8 + d * 7 + e * 6 + f * 5 + g * 4 + h * 3 + i * 2;
        int resto1 = soma1 % 11;
        int digito1 = (resto1 == 0 || resto1 == 1) ? 0 : 11 - resto1;

        int soma2 = a * 11 + b * 10 + c * 9 + d * 8 + e * 7 + f * 6 + g * 5 + h * 4 + i * 3 + digito1 * 2;
        int resto2 = soma2 % 11;
        int digito2 = (resto2 == 0 || resto2 == 1) ? 0 : 11 - resto2;

        return j == digito1 && k == digito2;
    }

    public void setNumero(String numero) {
        if (validarNumero(numero)) {
            this.numero = numero;
        } else {
            this.numero = null;
            this.diaEmissao = 0;
            this.mesEmissao = 0;
            this.anoEmissao = 0;
        }
    }

    public String getNumero() {
        return this.numero;
    }

    public void setEmissao(int dia, int mes, int ano) {
        if (this.numero == null) return;

        if (ano < 1900 || ano > 2025 || mes < 1 || mes > 12) return;

        boolean dataValida = false;

        if (mes == 2) {
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                dataValida = (dia >= 1 && dia <= 29);
            } else {
                dataValida = (dia >= 1 && dia <= 28);
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            dataValida = (dia >= 1 && dia <= 30);
        } else {
            dataValida = (dia >= 1 && dia <= 31);
        }

        if (dataValida) {
            this.diaEmissao = dia;
            this.mesEmissao = mes;
            this.anoEmissao = ano;
        }
    }

    public String getEmissao() {
        if (this.numero == null || diaEmissao == 0 || mesEmissao == 0 || anoEmissao == 0) {
            return "Para exibir a data de emissao, entre com data e numeracao validas!";
        }
        return String.format("%02d/%02d/%d", diaEmissao, mesEmissao, anoEmissao);
    }

    public void setNome(String nome) {
        if (nome != null) {
            nome = nome.toUpperCase();
            boolean soletras = true;
            for (int i = 0; i < nome.length(); i++) {
                char letra = nome.charAt(i);
                if ((letra < 65 || letra > 90) && letra != 32) {
                    soletras = false;
                    break;
                }
            }
            this.nome = soletras ? nome : null;
        }
    }

    public String getNome() {
        return this.nome;
    }
}