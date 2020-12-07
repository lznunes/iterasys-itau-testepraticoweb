package TestSitePetz;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import Base.Base;

public class TestSite extends Base{
	
	
	
	@Test
	public void TesteSimples() {		
		//carregaSite();
		String pastalog = gerapastalog();
		homePage.localizProdutos("Ra��o");
		capturascreen("Ra��o", "resultado_pesquisa",pastalog);
		homePage.clicanoProduto3();
		String decricao = homePage.descricaoProduto();
		String preco = homePage.preconormalProduto();
		capturascreen("Ra��o", "produto_selecionado", pastalog);
		homePage.clicaAdicionarCarrinho();
		String decricaocarrinho = homePage.descricaoProduto();
		String precocarrinho = homePage.precoProdutoCarrinho();
		capturascreen("Ra��o", "adicionado_carrinho",pastalog);
		homePage.limpacarrinho();
		assertEquals(decricao, decricaocarrinho);
		assertEquals(preco, precocarrinho);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/massateste.csv", numLinesToSkip = 1, delimiter= ';')
	public void TesteMassa(String Produto) {		
		//carregaSite();
		String pastalog = gerapastalog();
		homePage.localizProdutos(Produto);
		capturascreen("Ra��o", "resultado_pesquisa", pastalog);
		homePage.clicanoProduto3();
		String decricao = homePage.descricaoProduto();
		String preco = homePage.preconormalProduto();
		capturascreen("Ra��o", "produto_selecionado", pastalog);
		homePage.clicaAdicionarCarrinho();
		String decricaocarrinho = homePage.descricaoProduto();
		String precocarrinho = homePage.precoProdutoCarrinho();
		capturascreen("Ra��o", "adicionado_carrinho", pastalog);
		homePage.limpacarrinho();
		assertEquals(decricao, decricaocarrinho);
		assertEquals(preco, precocarrinho);
	}
	
	
	

}
