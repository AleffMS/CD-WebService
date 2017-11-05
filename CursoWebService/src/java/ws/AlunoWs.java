/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.AlunoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Aluno;

/**
 * REST Web Service
 *
 * @author aleff
 */
@Path("curso")
public class AlunoWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimesWs
     */
    public AlunoWs() {
    }

    /**
     * Retrieves representation of an instance of ws.AlunoWs
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Aluno/get/{id}")
    public String getJson(@PathParam("id") int id) {
        AlunoDAO dao = new AlunoDAO();
        Aluno a = new Aluno();
     
        a.setId(id);
        a = dao.buscar(a);
        
        //Converte para Gson
        Gson g = new Gson();
        return g.toJson(a);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Aluno/list")
    public String listAlunos() {
        
        List<Aluno> lista;
        
        AlunoDAO dao = new AlunoDAO();
        lista = dao.listar();
 
        //Converte para Gson
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of AlunoWs
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
