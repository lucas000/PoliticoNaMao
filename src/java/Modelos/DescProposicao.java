/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Vicom
 */
public class DescProposicao {
    
    private Proposicao proposicao;
   private ProposicaoAutor proposicaoAutor;

    public DescProposicao(Proposicao proposicao, ProposicaoAutor proposicaoAutor) {
        this.proposicao = proposicao;
        this.proposicaoAutor = proposicaoAutor;
    }

    public ProposicaoAutor getProposicaoAutor() {
        return proposicaoAutor;
    }

    public void setProposicaoAutor(ProposicaoAutor proposicaoAutor) {
        this.proposicaoAutor = proposicaoAutor;
    }

    public Proposicao getProposicao() {
        return proposicao;
    }

    public void setProposicao(Proposicao proposicao) {
        this.proposicao = proposicao;
    }

    @Override
    public String toString() {
        return "DescProposicao{" + "proposicao=" + proposicao + ", proposicaoAutor=" + proposicaoAutor + '}';
    }
   
   
    
}
