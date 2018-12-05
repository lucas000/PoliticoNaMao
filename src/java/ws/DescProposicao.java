/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Consultas.TesteQueriesProposicao;
import Modelos.ProposicaoAutor;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vicom
 */
@WebService(serviceName = "DescProposicao")
public class DescProposicao {
    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscaProposicaoAutor")
    public ProposicaoAutor buscaProposicaoAutor(@WebParam(name = "idProposicao") int idProposicao) {
        TesteQueriesProposicao b = new TesteQueriesProposicao();
        return b.buscaProposicaoautor(idProposicao);
    }
}
