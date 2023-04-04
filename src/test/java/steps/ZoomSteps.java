package steps;

import io.cucumber.java.en.Given;
import pages.ZoomPage;

public class ZoomSteps {

    @Given("que preencho o campo de busca com o produto {string}")
    public void euPesquisoPeloProduto(String produto) {
        ZoomPage.euPesquisoPeloProduto(produto);
    }
    @Given("eu clico no botao de buscar")
    public void clicarBotaoBuscar() {
        ZoomPage.clicarBotaoBuscar();
    }
}
