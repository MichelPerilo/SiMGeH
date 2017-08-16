/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.model.Medico;
import java.util.List;

/**
 *
 * @author Bartô
 */
public interface IRepositorioMedico {
    public boolean cadastrarMedico(Medico medico);
    
    public void buscarMedico(int crmv, int MATRICULA, String CPF);
    
   /**
    *
    * @param medico: recebe uma instância de médico atualizada(com os novos dados).
    */ 
    public boolean atualizarCDMedico(Medico medico);
    
    public boolean removerMedico(Medico medico);
    
    public List<Medico> listarMedicos();
}
