package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<CarrinhoCompras> listaCarrinhoCompras = new ArrayList<>();

		CarrinhoComprasFactory carrinhoCompras = new CarrinhoComprasFactory();
		CarrinhoCompras carrinhoJose =  carrinhoCompras.criar("Jose");
		carrinhoJose.adicionarItem(new Produto(1L,"Chinelo"),new BigDecimal(10), 5);
		carrinhoJose.adicionarItem(new Produto(2L,"Sapato"),new BigDecimal(15), 10);
		carrinhoJose.adicionarItem(new Produto(3L,"Calça"),new BigDecimal(15), 15);
		CarrinhoCompras carrinhoClaudio = carrinhoCompras.criar("Claudio");
		carrinhoClaudio.adicionarItem(new Produto(1L,"Calça"),new BigDecimal(10.25), 5);
		carrinhoClaudio.adicionarItem(new Produto(2L,"Sapato"),new BigDecimal(1.50), 10);
		carrinhoClaudio.adicionarItem(new Produto(3L,"Chinelo"),new BigDecimal(15), 15);

		listaCarrinhoCompras.add(carrinhoJose);
		listaCarrinhoCompras.add(carrinhoClaudio);

		System.out.println(carrinhoClaudio.getValorTotal());
		System.out.println(carrinhoClaudio.getItens());

		System.out.println(carrinhoJose.getValorTotal());
		System.out.println(carrinhoJose.getItens());
		carrinhoClaudio.removerItem(new Produto(1L, "Chinelo"));
		System.out.println(carrinhoClaudio.getItens());
		System.out.println(carrinhoCompras.getValorTicketMedio(listaCarrinhoCompras));
		carrinhoCompras.invalidar("Jose");
		System.out.println(carrinhoCompras.carrinhoCliente.size());

	}



}
