package br.pucpr.prog4.lojavirtual.models.dao;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    
    PessoaDAO getPessoaDAO();
}
