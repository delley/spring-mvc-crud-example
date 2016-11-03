package br.com.froli.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import br.com.froli.springmvc.model.Contato;

public class ContatoDAOImpl implements ContatoDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContatoDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Contato contato) {
		if(contato.getCodigo() > 0) {
			// Update
			String sql = "UPDATE CONTATO SET NOME=?, EMAIL=?, ENDERECO=?, TELEFONE=? WHERE CODIGO=?";
			jdbcTemplate.update(sql, contato.getNome(), contato.getEmail(), contato.getEndereco(), contato.getTelefone(), contato.getCodigo());
		} else {
			// Insert
			String sql = "INSERT INTO CONTATO (NOME, EMAIL, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, contato.getNome(), contato.getEmail(), contato.getEndereco(), contato.getTelefone());
		}
	}

	@Override
	public void delete(int codigo) {
		String sql = "DELETE FROM CONTATO WHERE CODIGO=?";
		jdbcTemplate.update(sql, codigo);
	}

	@Override
	public Contato get(int codigo) {
		String sql = "SELECT * FROM CONTATO WHERE CODIGO=?";
		
		return jdbcTemplate.query(sql, new Object[] { codigo }, new ResultSetExtractor<Contato>() {

			@Override
			public Contato extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
	                Contato contato = new Contato();
	                contato.setCodigo(rs.getLong("CODIGO"));
	                contato.setNome(rs.getString("NOME"));
	                contato.setEmail(rs.getString("EMAIL"));
	                contato.setEndereco(rs.getString("ENDERECO"));
	                contato.setTelefone(rs.getString("TELEFONE"));
	                return contato;
	            }
	 
	            return null;
			}
			
		});
	}

	@Override
	public List<Contato> list() {
		String sql = "SELECT * FROM CONTATO";
	    List<Contato> contatos = jdbcTemplate.query(sql, new RowMapper<Contato>() {
	 
	        @Override
	        public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Contato contato = new Contato();
	 
	        	contato.setCodigo(rs.getLong("CODIGO"));
                contato.setNome(rs.getString("NOME"));
                contato.setEmail(rs.getString("EMAIL"));
                contato.setEndereco(rs.getString("ENDERECO"));
                contato.setTelefone(rs.getString("TELEFONE"));
	 
	            return contato;
	        }
	 
	    });
	 
	    return contatos;
	}

}
