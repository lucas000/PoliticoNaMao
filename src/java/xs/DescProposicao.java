/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xs;

import Consultas.TesteQueriesProposicao;
import Modelos.DescProposicao1;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lucas
 */
@WebService(serviceName = "DescProposta")
public class DescProposicao {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "DescricaoPrposicao")
    public DescProposicao1 hello(@WebParam(name = "id") int idproposicao) {
        
        TesteQueriesProposicao b = new TesteQueriesProposicao();
        
       DescProposicao1 n = new DescProposicao1();
       n.setProposicao(b.buscaProposicao(idproposicao));
       n.setProposicaoAutor(b.buscaProposicaoautor(idproposicao));
       
        return n;
    }
}
