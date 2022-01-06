package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory{

	Set<String> carrinhoCliente = new LinkedHashSet<>();

	public CarrinhoComprasFactory() {

	}

    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {

		if(carrinhoCliente.contains(identificacaoCliente)){
			System.out.print("Carrinho de Compras ja usado pelo cliente");
		}

		this.carrinhoCliente.add(identificacaoCliente);

		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		return carrinhoCompras;

    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio(List<CarrinhoCompras> lista)  {

		double temp;
		double valortotal = 0d;
		for (CarrinhoCompras carrinhoCompras : lista) {
			valortotal += Double.parseDouble(String.valueOf(carrinhoCompras.getValorTotal()));
		}
		temp = valortotal/carrinhoCliente.size();

		BigDecimal valorTicketMedio = new BigDecimal(temp);
		valorTicketMedio = valorTicketMedio.setScale(2, RoundingMode.HALF_UP);
		return valorTicketMedio;
    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {

		if(carrinhoCliente.contains(identificacaoCliente)){
			carrinhoCliente.remove(identificacaoCliente);
			return true;
		}

		return false;
    }
}
