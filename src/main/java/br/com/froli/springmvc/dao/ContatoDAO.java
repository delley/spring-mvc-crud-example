package br.com.froli.springmvc.dao;

import java.util.List;

import br.com.froli.springmvc.model.Contato;

public interface ContatoDAO {
	
	public void saveOrUpdate(Contato contato);
    
    public void delete(int codigo);
     
    public Contato get(int codigo);
     
    public List<Contato> list();
    
}
