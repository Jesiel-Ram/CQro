package com.cias.work.ws;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.cias.work.dto.PersonaDTO;
import com.cias.work.filtros.FiltrosPersona;



@Path("/CIASQ")
public class RestServerPersona {

	@GET
    @Path("/persona")
	@Produces(MediaType.TEXT_HTML)
    public Response getAllUser() throws ParseException {
		PersonaDTO dto = new PersonaDTO();
		FiltrosPersona populate = new FiltrosPersona();
    	dto.setData(populate.getAll());
    	//System.out.println("RH " + dto);
        return Response.status(200).entity(new JSONObject(dto).toString()).build();
    }
	
	@GET
    @Path("/agregar/{nombre}/{primer_apellido}/{segundo_apellido}/{telefono}")
	@Produces(MediaType.TEXT_HTML)
    public Response getAllUserAceptar(@PathParam("nombre") String nombre, @PathParam("primer_apellido") String primer_apellido, @PathParam("segundo_apellido") String segundo_apellido, @PathParam("telefono") String telefono) throws ParseException {
		FiltrosPersona fs = new FiltrosPersona();
		PersonaDTO dto = new PersonaDTO();
		System.out.println("A ver");
    	fs.getAgregar(nombre, primer_apellido, segundo_apellido, telefono);
        return Response.status(200).entity(new JSONObject(dto).toString()).build();
    }
	
	@GET
    @Path("/actualizar/{nombre}/{primer_apellido}/{segundo_apellido}/{telefono}/{id}")
	@Produces(MediaType.TEXT_HTML)
    public Response getAllUserActualizar(@PathParam("nombre") String nombre, @PathParam("primer_apellido") String primer_apellido, @PathParam("segundo_apellido") String segundo_apellido, @PathParam("telefono") String telefono, @PathParam("id") String id) throws ParseException {
		FiltrosPersona fs = new FiltrosPersona();
		System.out.println("Paso");
		PersonaDTO dto = new PersonaDTO();
    	fs.getActualizar(nombre, primer_apellido,segundo_apellido,telefono, id);
        return Response.status(200).entity(new JSONObject(dto).toString()).build();
    }
	
	@GET
	@Path("/buscar/{buscarP}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFechaIdBitacora(@PathParam("buscarP") String buscarP) throws ParseException{
		
		PersonaDTO dto = new PersonaDTO();
		FiltrosPersona fs = new FiltrosPersona();
		
		
		dto.setData(fs.filtroBitacora(buscarP));
		
		return Response.status(200).entity(new JSONObject(dto).toString()).build();
	}
	
}
