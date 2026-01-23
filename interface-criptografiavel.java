interface Criptografiavel {
    public String encriptar(String mensagem);
    public String decifrar(String mensagem);
}

class MaquinaEspia {
    private Criptografiavel[] algoritmos = new Criptografiavel[10];
    private int contador = 1;

    public Criptografiavel[] getAlgoritmos() {
        return algoritmos;
    }

    public void setAlgoritmos(Criptografiavel[] algoritmos) {
        this.algoritmos = algoritmos;
    }

    public void addAlgoritmo(Criptografiavel algoritmo) {
        if (algoritmo != null && contador < 10) {
            algoritmos[contador] = algoritmo;
            contador++;
        }
    }

    public String encriptar(int algoritmo, String mensagem) {
        if (algoritmo >= 0 && algoritmo < contador && algoritmos[algoritmo] != null && mensagem != null) {
            return algoritmos[algoritmo].encriptar(mensagem).toUpperCase();
        }
        return "";
    }

    public String decifrar(int algoritmo, String mensagem) {
        if (algoritmo >= 0 && algoritmo < contador && algoritmos[algoritmo] != null && mensagem != null) {
            return algoritmos[algoritmo].decifrar(mensagem).toUpperCase();
        }
        return "";
    }
}

class CifraDeCesar implements Criptografiavel {
    private int deslocamento;

    public CifraDeCesar() {
        this.deslocamento = 3;
    }

    public CifraDeCesar(int deslocamento) {
        if (deslocamento >= 3 && deslocamento <= 20) {
            this.deslocamento = deslocamento;
        } else {
            this.deslocamento = 3;
        }
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        if (deslocamento >= 3 && deslocamento <= 20) {
            this.deslocamento = deslocamento;
        } else {
            this.deslocamento = 3;
        }
    }

    public String encriptar(String mensagem) {
        if (mensagem == null) return "";
        String retorno = "";
        mensagem = mensagem.toUpperCase();
        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);
            if (Character.isLetter(c)) {
                char base = (Character.isLowerCase(c)) ? 'a' : 'A';
                retorno += (char) ((c - base + deslocamento) % 26 + base);
            } else {
                retorno += c;
            }
        }
        return retorno;
    }

    public String decifrar(String mensagem) {
        if (mensagem == null) return "";
        String retorno = "";
        mensagem = mensagem.toUpperCase();
        for (int i = 0; i < mensagem.length(); i++) {
            char c = mensagem.charAt(i);
            if (Character.isLetter(c)) {
                char base = (Character.isLowerCase(c)) ? 'a' : 'A';
                retorno += (char) ((c - base - deslocamento + 26) % 26 + base);
            } else {
                retorno += c;
            }
        }
        return retorno;
    }
}

class CriptografiaInversa implements Criptografiavel {
    public String encriptar(String mensagem) {
        if (mensagem == null) return "";
        mensagem = mensagem.toUpperCase();
        String retorno = "";
        for (int i = mensagem.length() - 1; i >= 0; i--) {
            retorno += mensagem.charAt(i);
        }
        return retorno;
    }

    public String decifrar(String mensagem) {
        if (mensagem == null) return "";
        return encriptar(mensagem);
    }
}