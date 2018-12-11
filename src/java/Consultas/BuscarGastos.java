/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

/**
 *
 * @author Lucas
 */
public class BuscarGastos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TesteQueriesProposicao gasto = new TesteQueriesProposicao();
        
        gasto.buscaProposicaoPorNomeAutor("ABEL MESQUITA JR.");
    }
}
