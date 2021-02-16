package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")

public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto prod1, prod2;

	

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		prod1 = new Produto("produto 1", 1.00);
		prod2 = new Produto("produto 2", 2.00);
		carrinho.addItem(prod1);
		carrinho.addItem(prod2);
	}

	@DisplayName("Testa obter o valor total")
	@Test

	public void testGetValorTotal() {
		double valorTotal = carrinho.getValorTotal();
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}

	@DisplayName("Testa quantidade de itens no carrinho")
	@Test

	public void testGetQtdeItems() {
		Assertions.assertEquals(2, carrinho.getQtdeItems());
	}

	@DisplayName("Testa adicionar item")
	@Test

	public void testAddItem() {
		Produto prod3 = new Produto("produto 3", 3.00);
		carrinho.addItem(prod3);
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}

	

	@DisplayName("Testa remover item")
	@Test

	public void testRemoveItemSucesso() {
		try {
			carrinho.removeItem(prod1);
		}catch (ProdutoNaoEncontradoException e) {
			e.printStackTrace();
		}
	}

	
	public void testRemoveItemInexistente() {
		Produto prod4 = new Produto ("produto 4", 4.00);
		try {
			carrinho.removeItem(prod4);;
		} catch (ProdutoNaoEncontradoException e) {
			Assertions.assertTrue(e instanceof ProdutoNaoEncontradoException);
		}
	}

	@DisplayName("Testa esvaziar carrinho")
	@Test

	public void testEsvazia() {
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
}
