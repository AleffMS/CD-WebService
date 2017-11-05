/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author marcelosiedler
 */
public class AlunoDAO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    public AlunoDAO() {

    }

    public boolean inserir(Aluno aluno) {
        String sql = "INSERT INTO tb_aluno(id,nome,telefone,endereco,curso) VALUES(?,?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, aluno.getId());
            pst.setString(2, aluno.getNome());
            pst.setString(3, aluno.getTelefone());
            pst.setString(4, aluno.getEndereco());
            pst.setString(5, aluno.getCurso());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean atualizar(Aluno aluno) {
        String sql = "UPDATE tb_aluno set nome=?,telefone=?,endereco=?,curso=? where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getTelefone());
            pst.setString(3, aluno.getEndereco());
            pst.setString(4, aluno.getCurso());
            pst.setInt(5, aluno.getId());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean excluir(Aluno aluno) {
        String sql = "DELETE FROM tb_aluno where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, aluno.getId());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public List<Aluno> listar() {
        String sql = "SELECT * FROM tb_aluno";
        List<Aluno> retorno = new ArrayList<>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Aluno item = new Aluno();
                item.setId(res.getInt("id"));
                item.setNome(res.getString("nome"));
                item.setTelefone(res.getString("telefone"));
                item.setEndereco(res.getString("endereco"));
                item.setCurso(res.getString("curso"));

                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

    public Aluno buscar(Aluno aluno) {
        String sql = "SELECT * FROM tb_aluno where id=?";
        Aluno retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, aluno.getId());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Aluno();
                retorno.setId(res.getInt("id"));
                retorno.setNome(res.getString("nome"));
                retorno.setTelefone(res.getString("telefone"));
                retorno.setEndereco(res.getString("endereco"));
                retorno.setCurso(res.getString("curso"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

}
