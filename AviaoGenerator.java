package Trabalho_01;

public class AviaoGenerator {
    static int idCounterDecolagem = 1; 
    static int idCounterPouso = 2; 
    
    public static Aviao gerarAviaoDecolagem() {
        Aviao aviao = new Aviao();
        aviao.setId(idCounterDecolagem);
        idCounterDecolagem += 2; 
        aviao.setDecolagem(true); 
        aviao.setCombustivel(20);
        aviao.setTempoEspera(0); 
        return aviao;
    }

    public static Aviao gerarAviaoPouso() {
        Aviao aviao = new Aviao();
        aviao.setId(idCounterPouso);
        idCounterPouso += 2; 
        aviao.setDecolagem(false);
        aviao.setCombustivel((int) (Math.random() * 10) + 1); 
        aviao.setTempoEspera(0);
        return aviao;
    }

    public static int radomInt() {
        return (int) (Math.random() * (2 - 0 + 1)) + 0;
    }


}
