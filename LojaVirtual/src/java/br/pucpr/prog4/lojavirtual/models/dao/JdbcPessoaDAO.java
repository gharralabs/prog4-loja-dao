package br.pucpr.prog4.lojavirtual.models.dao;

import br.pucpr.prog4.lojavirtual.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class JdbcPessoaDAO implements  PessoaDAO {

    private Connection conexão;
    
    public void setConexão(Connection conexão)
    {
        this.conexão = conexão;
    }
    
    @Override
    public Pessoa inserir(Pessoa pessoa) 
    {
        String sql;
        sql = "INSERT INTO Pessoa("
                + "nome,"
                + "dataNascimento,"
                + "tipo,"
                + "sexo)"
                + " VALUES (?, ? , ?, ?)";

        PreparedStatement ps;
        try
        {
            ps = conexão.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setDate(2,  new java.sql.Date(pessoa.getDataNascimento().getTime()));
            ps.setString(3, pessoa.getTipoPessoa());
            ps.setString(4, pessoa.getSexo());
            ps.executeUpdate();
            
            return pessoa;
        } 
        catch (Exception ex) {
            throw new DaoException("Ocorreu um erro ao inserir uma pessoa no banco de dados");
        }
    }

    
    
}
