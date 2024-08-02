package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

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

}
