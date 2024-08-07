package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class FilmeSteps {

    @E("que tenha um payload valido da API de Filme")
    public void queTenhaUmPayloadValidoDaAPIDeFilme() {
        FilmesMap.initAll();
    }

    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizoUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.post(FilmesMap.getHeader(),FilmesMap.getFilme(), ContentType.JSON, "filmes");
    }

    @E("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMap.getFilme().get("nome").toString();
        param.put("nome", nome);
        RestUtils.get(FilmesMap.getHeader(), param, "filmes");

    }

    @Dado("altero o indice {int} da lista de categorias de filme com os valores")
    public void alteroOIndiceDaListaDeCategoriasDeFilmeComOsValores(int indice, Map<String, String> map) {
       FilmesMap.getListCategoria().get(indice).putAll(map);

    }
    @Quando("realizo uma requisicao do tipo PUT de Filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
        RestUtils.put(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes/" + FilmesMap.id);

    }

    @Quando("realizo uma requisicao do tipo Delete de Filme")
    public void realizoUmaRequisicaoDoTipoDeleteDeFilme() {
        RestUtils.delete(FilmesMap.getHeader(), "filmes/" +FilmesMap.id);

    }
}
