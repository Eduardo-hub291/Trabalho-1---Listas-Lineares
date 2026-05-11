package Trabalho_01;

public class Aviao {
    int id;
    boolean decolagem;
    int combustivel;
    int tempoEspera;

    // Métodos
    public void diminuirCombustivel() {
        if (combustivel > 0) {
            combustivel--;
        }
    }
    public boolean estaSemCombustivel() { 
        return combustivel <= 0;
    }
    public void aumentarTempoEspera() {
        tempoEspera++;
    }
    public boolean estaEmEmergencia() {
        return combustivel < 2;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public boolean isDecolagem() {
        return decolagem;
    }
    public int getCombustivel() {
        return combustivel;
    }
    public int getTempoEspera() {
        return tempoEspera;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDecolagem(boolean decolagem) {
        this.decolagem = decolagem;
    }
    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }
    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    // tostring
    @Override
    public String toString() {
        return "Aviao{" +
                "id=" + id +
                ", " + (decolagem ? "decolagem" : "pouso") +
                ", combustivel=" + combustivel +
                ", tempoEspera=" + tempoEspera +
                '}';
    }
}
