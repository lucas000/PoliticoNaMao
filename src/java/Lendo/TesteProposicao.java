/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import Consultas.TesteQueriesProposicao;
import Modelos.Proposicao;
import Modelos.ProposicaoAutor;
import Modelos.ViewProposicao;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vicom
 */
public class TesteProposicao {
    public static void main(String[] args) throws ParseException, IOException {
        // ProposicaoDOM.lerPreposicao2018();//inserir Proposicoes 2018
       // Proposicao.lerPreposicoes(); //inserir Proposicoes 2000 a 2017
       
       //  ProposicaoAutor.lerProposicaoAutor();
         
         
        Consultas.TesteQueriesProposicao  b = new TesteQueriesProposicao();
         
        List<Proposicao> listaProposicao =   b.buscaProposicaoAno(2018);
     
       
      

    
    
       
    }
    
}
