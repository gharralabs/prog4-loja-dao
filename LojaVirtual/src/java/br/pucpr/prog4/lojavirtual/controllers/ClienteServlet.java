/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.lojavirtual.controllers;

import br.pucpr.prog4.lojavirtual.models.ClienteManager;
import br.pucpr.prog4.lojavirtual.models.ClienteManagerImpl;
import br.pucpr.prog4.lojavirtual.models.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonhy.haniu
 */
public class ClienteServlet extends HttpServlet {

           
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastroCliente.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getParameter("name"));
        String cpfAux;
        cpfAux = request.getParameter("cpf");
        Long cpf;
        cpf = Long.parseLong(cpfAux);
        pessoa.setCpf(cpf);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataNascimento = sdf.parse(request.getParameter("dataNasc"));
            pessoa.setDataNascimento(dataNascimento);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        pessoa.setSexo(request.getParameter("sex"));
        pessoa.setTipoPessoa(request.getParameter("pessoa"));
        
        ClienteManager manager;
        manager = new ClienteManagerImpl();
        manager.cadastrar(pessoa);
        
    }

    

}
