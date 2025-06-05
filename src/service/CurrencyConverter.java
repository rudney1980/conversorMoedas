package service;

import com.google.gson.Gson;
import model.ExchangeResponse;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_KEY = "d84574b3382cddf9f67ae33d";

    public double converter(String baseCode, String targetCode, double valor) {

        try {
            String endpoint = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCode;
            URL url = new URL(endpoint);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            if (conexao.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(conexao.getInputStream());
                ExchangeResponse resposta = new Gson().fromJson(reader, ExchangeResponse.class);

                Double taxa = resposta.getConversion_rates().get(targetCode);
                if (taxa != null) {
                    return valor * taxa;
                } else {
                    System.out.println("Moeda de destino não encontrada.");
                }
            } else {
                System.out.println("Erro ao acessar a API. Código: " + conexao.getResponseCode());
            }

        } catch (Exception e) {
            System.out.println("Erro durante a conversão: " + e.getMessage());
        }
        return 0.0;
    }
}
