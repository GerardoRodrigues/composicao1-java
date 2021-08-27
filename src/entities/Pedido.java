package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private StatusPedido status;
	
	private Cliente cliente;
	private List<PedidoItem> pedidos = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoItem> getPedidos() {
		return pedidos;
	}
	
	public void addItem(PedidoItem pedido) {
		pedidos.add(pedido);
	}
	
	public void removeItem(PedidoItem pedido) {
		pedidos.remove(pedido);
	}
	
	public double total() {
		double soma = 0;
		for(PedidoItem p : pedidos) {
			soma += p.precoTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Resumo: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Pedido dos Itens:\n");
		for(PedidoItem p : pedidos) {
			sb.append(p + "\n");
		}
		sb.append("Preco total: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
}
