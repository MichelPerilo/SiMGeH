/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.ProcuraProntuarioInexistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Prontuario;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioProntuario {
    
    public void cadastra(Prontuario p) throws IOException, CadastroProntuarioExistenteException;
    public Prontuario procurar(Animal a) throws ProcuraProntuarioInexistenteException;
    public boolean existe(Animal a);
    public void remover(Animal a) throws IOException, ProcuraProntuarioInexistenteException;
    public void  imprimiProntuario() throws IOException;
    
}
