package pages;

import org.openqa.selenium.By;

public class ZoomPage extends BasePage{

    public static String campoPesquisa = "//input[@data-test='input-search']";
    public static String botaoPesquisar = "//header/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]";
    public static String filtro = "//span[contains(text(),'Categoria : Celular e Smartphone')]";


    public static void euPesquisoPeloProduto(String produto){
        try {
            write(By.xpath(campoPesquisa),produto);
        } catch (Exception e) {
            System.err.println("Erro no metodo euPesquisoPeloProduto");
        }
    }
    public static void clicarBotaoBuscar(){
        try {
            click(By.xpath(botaoPesquisar));
        } catch (Exception e) {
            System.err.println("Erro no metodo clicarBotaoBuscar");
        }
    }
}
