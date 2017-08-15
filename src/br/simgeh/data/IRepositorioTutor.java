/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.exeception.ProcurarTutorInexistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Tutor;
import java.io.IOException;

/**
 *
 * @author Michel Perilo
 */
public interface IRepositorioTutor {
    
    public void cadastra(Tutor t) throws IOException, CadastroTutorExistenteException;
    public Tutor procurar(Animal a) throws ProcurarTutorInexistenteException;
    public boolean existe(Tutor t);
    public void remover(Animal a) throws IOException, ProcurarTutorInexistenteException;
    public void  imprimiTutor() throws IOException;
}
