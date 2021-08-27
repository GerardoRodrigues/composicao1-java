package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do cliente: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email: ");
		String emailCliente = sc.nextLine();
		System.out.print("Aniversario (DD/MM/YYYY): ");
		Date niverCliente = sdf.parse(sc.next());
		Cliente cliente = new Cliente(nomeCliente, emailCliente, niverCliente);
		
		System.out.print("Status do pedido? ");
		StatusPedido statusPedido = StatusPedido.valueOf(sc.next());
		
		Date date = new Date();
		Pedido pedido = new Pedido(date, statusPedido, cliente);
		
		System.out.println("Quantos itens no pedido? ");
		int n = sc.nextInt();

		for(int i=1; i<=n; i++) {
			sc.nextLine();
			System.out.println("Item #" + i + ":");
			System.out.print("Nome do Produto: ");
			String nomeProduto = sc.nextLine();
			System.out.print("Preco do Produto: ");
			double precoProduto = sc.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int quantProduto = sc.nextInt();
			
			PedidoItem pedidoItem = new PedidoItem(quantProduto, precoProduto, produto);
			
			pedido.addItem(pedidoItem);
		}
		
		System.out.println(pedido);
		
		sc.close();
	}

}
