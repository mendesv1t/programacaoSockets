package redes;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> palavras = new HashMap<>();

    public Dicionario() {
        this.palavras.put("porta", "gateway");
        this.palavras.put("redes", "network");
        this.palavras.put("requisição", "request");
        this.palavras.put("resposta", "response");
        this.palavras.put("cabeçalho", "header");
        this.palavras.put("enlace", "link");
        this.palavras.put("protocolo", "protocol");
        this.palavras.put("rota", "route");
        this.palavras.put("transporte", "transport");
        this.palavras.put("aplicação", "application");

    }

    public Map<String, String> getPalavras() {
        return palavras;
    }

    public String traduzir(String palavraChave) {
        return palavras.get(palavraChave);
    }
}
