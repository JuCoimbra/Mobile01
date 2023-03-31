package br.com.senaicimatec.agualife;
public class ConsumoAgua {
    public static int calcularConsumoDiarioAgua(double peso, int idade) {
        int consumo = 0;

        if (idade <= 17){
            consumo = (int) (peso * 40);
        }else if (idade >= 18 && idade <= 55){
            consumo = (int) (peso * 40);
        }else if (idade >= 56 && idade <= 65){
            consumo = (int) (peso * 30);
        }else if (idade > 66){
            consumo = (int) (peso * 25);
        }
        return consumo;
    }
}
