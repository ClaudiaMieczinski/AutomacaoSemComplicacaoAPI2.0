package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

import java.util.Map;


public class LoginSteps {
    String url = "http://localhost:8080/";

    @Dado("que eu tenha um payload valido da API de Login")
    public void queEuTenhaUmPayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
    }

    @Dado("que eu tenha um payload da API de Login com as seguintes informacoes")
    public void queEuTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformacoes(Map<String, Object> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI(url);
        LoginMap.getLogin().putAll(map);

   }

    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
       LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }
}
