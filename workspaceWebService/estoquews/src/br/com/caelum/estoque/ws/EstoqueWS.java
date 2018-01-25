package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;


//importando o servi�o web service [javax.jws.WebService]
@WebService

public class EstoqueWS {
	//criando e instanciando o ItemDao
	private ItemDao dao = new ItemDao();
	
	//m�todo publico que devolve uma lista de itens
	public List<Item> getItens(){
		
		System.out.println("Chamando o getItens()"); //s� para saber que o m�todo foi chamado
		List<Item> lista = dao.todosItens();
		return lista;
	}
}
