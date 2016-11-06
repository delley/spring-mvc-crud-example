package br.com.froli.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.froli.springmvc.dao.ContatoDAO;
import br.com.froli.springmvc.model.Contato;

@Controller
public class ContatoController {

	@Autowired
	private ContatoDAO contatoDAO;
	
	@RequestMapping("/")
	public ModelAndView listar(ModelAndView model) {
		List<Contato> contatos = contatoDAO.list();
		model.addObject("contatos", contatos);
		model.setViewName("contato");
		
		return model;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelAndView model) {
		Contato contato = new Contato();
		model.addObject("contato", contato);
		model.setViewName("contatoForm");
		
		return model;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Contato contato) {
		System.out.println(contato);
		contatoDAO.saveOrUpdate(contato);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public ModelAndView excluir(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("id"));
		contatoDAO.delete(codigo);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public ModelAndView editar(HttpServletRequest request) {
		int codigo = Integer.parseInt(request.getParameter("id"));
		Contato contato = contatoDAO.get(codigo);
		ModelAndView model = new ModelAndView("contatoForm");
		model.addObject("contato", contato);
		
		return model;
	}
}
