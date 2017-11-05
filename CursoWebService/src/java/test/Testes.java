/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AlunoDAO;
import model.Aluno;

/**
 *
 * @author aleff
 */
public class Testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int id = 1;

        Aluno a = new Aluno();
        a.setId(id);
        
        AlunoDAO dao = new AlunoDAO();
        a = dao.buscar(a);

        System.out.println(a.getId());
        System.out.println(a.getNome());
        System.out.println(a.getTelefone());
        System.out.println(a.getEndereco());
        System.out.println(a.getCurso());
    }

}
