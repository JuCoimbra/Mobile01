package br.com.senaicimatec.agualife;
import java.util.ArrayList;

public class GerenciamentoAtleta {
        private ArrayList<Atleta> listaAtletas;

    public GerenciamentoAtleta() {
        listaAtletas = new ArrayList<>();
    }

    public void cadastrarAtleta(Atleta atleta) {
        listaAtletas.add(atleta);
    }

    public ArrayList<Atleta> getListaAtletas() {
        return listaAtletas;
    }

    public int calcularConsumoDiarioAgua(Atleta atleta) {
        int consumo = 0;

        if (atleta.getIdade() <= 17){
            consumo = (int) (atleta.getPeso()* 40);
        }else if (atleta.getIdade() >= 18 && atleta.getIdade() <= 55){
            consumo = (int) (atleta.getPeso()* 40);
        }else if (atleta.getIdade() >= 56 && atleta.getIdade()<= 65){
            consumo = (int) (atleta.getPeso()* 30);
        }else if (atleta.getIdade() > 66){
            consumo = (int) (atleta.getPeso()* 25);
        }
        return consumo;
    }
}
