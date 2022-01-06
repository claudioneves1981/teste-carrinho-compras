package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;
	private BigDecimal valorTotal;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {

		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
    }

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
		return this.produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
		return this.valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
		return this.quantidade;
	}

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {

		return this.valorTotal.multiply(BigDecimal.valueOf(this.quantidade));

    }

	@Override
	public String toString() {
		return "Item{" +
				"produto=" + produto +
				", valorUnitario=" + valorUnitario +
				", quantidade=" + quantidade +
				"}\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Item item = (Item) o;
		return quantidade == item.quantidade && Objects.equals(produto, item.produto) && Objects.equals(valorUnitario, item.valorUnitario) && Objects.equals(valorTotal, item.valorTotal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(produto, valorUnitario, quantidade, valorTotal);
	}
}
