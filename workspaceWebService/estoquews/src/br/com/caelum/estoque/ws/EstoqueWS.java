package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;


//importando o servi�o web service [javax.jws.WebService]
@WebService
public class EstoqueWS {
	//criando e instanciando o ItemDao
	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName="TodosOsItens") //serve para renomear a request/o name do m�todo
	@WebResult(name="itens")
	
	//m�todo publico que devolve uma lista de itens
	public ListaItens getItens(@WebParam(name="filtros") Filtros filtros){
		
		System.out.println("Chamando o getItens()"); //s� para saber que o m�todo foi chamado
		
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		
		return new ListaItens(itensResultado);		
	}
	
	@WebMethod(operationName="CadastrarItem")
	@WebResult(name="item")
	public Item cadastraItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, @WebParam(name="item") Item item) {
		System.out.println("Cadastrando item: " + item);
		
		this.dao.cadastrar(item);
		
		return item;
	}
}
