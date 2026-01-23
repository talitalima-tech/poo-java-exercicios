public class Robot {
    private int x;
    private int y;
    private String modelo;
    private float nivelBateria;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.nivelBateria = 100.0f;
        this.modelo = null;
    }

    public void andarFrente() {
        x += 1;
        reduzirBateria();
    }

    public void andarTraz() {
        x -= 1;
        reduzirBateria();
    }

    public void andarCima() {
        y += 1;
        reduzirBateria();
    }

    public void andarBaixo() {
        y -= 1;
        reduzirBateria();
    }

    public String getModelo() {
        return modelo;
    }

    public float getNivelBateria() {
        return nivelBateria;
    }

    public String getLocalizacao() {
        return "[" + x + ", " + y + "]";
    }

    public int getCoordX() {
        return x;
    }

    public int getCoordY() {
        return y;
    }

    public void comer(Plasma plasma) {
        nivelBateria += plasma.getEnergia();
        
        if (nivelBateria > 100.0f) {
            nivelBateria = 100.0f;
        } else if (nivelBateria < 0.0f) {
            nivelBateria = 0.0f;
        }
    }

    private void reduzirBateria() {
        nivelBateria -= 0.5f;
        if (nivelBateria < 0.0f) {
            nivelBateria = 0.0f;
        }
    }
}

public class Plasma {
    protected int energia;

    public Plasma(int energia) {
        if (energia >= 1 && energia <= 10) {
            this.energia = energia;
        } else {
            this.energia = 0; 
        }
    }

    public int getEnergia() {
        int temp = energia;
        energia = 0; 
        return temp;
    }

    public boolean isSombrio() {
        return false;
    }
}

public class PlasmaSombrio extends Plasma {

    public PlasmaSombrio(int energia) {
        super(0);  
        if (energia >= -10 && energia <= -1) {
            this.energia = energia; 
        } else {
            this.energia = 0;
        }
    }

    @Override
    public boolean isSombrio() {
        return true;
    }
}