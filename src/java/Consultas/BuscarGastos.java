/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.DespesasCotaExercicioAtividadeParlamentar_1;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class BuscarGastos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TesteQueriesDeputados gasto = new TesteQueriesDeputados();
        double gastos = gasto.buscaGastosTotaisDeputado("ABEL MESQUITA JR.");
        
        String resultado = String.format("%.2f", gastos);
        System.out.println("Gasto do deputado: " + resultado);
        /*
        int i = 0;
        double gastoTotal = 0.0;
        
        for (Object deputado : gastos) {
            DespesasCotaExercicioAtividadeParlamentar_1 est = (DespesasCotaExercicioAtividadeParlamentar_1) deputado;
            System.out.println(est.toString());
            gastoTotal+=est.getVlrdocumento();
            i++;
        }
        String resultado = String.format("%.2f", gastoTotal);
        System.out.println("Gasto do deputado: " + resultado);
        System.out.println("Total de resultados: " + i);*/
    }
}
