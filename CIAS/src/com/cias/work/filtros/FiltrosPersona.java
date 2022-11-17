package com.cias.work.filtros;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cias.work.dao.PersonaDao;
import com.cias.work.dto.PersonaDTO;
import com.cias.work.entity.PersonaEntity;



public class FiltrosPersona {
	public List<PersonaDTO> getAll() throws ParseException{
		List<PersonaDTO> list = new ArrayList<PersonaDTO>();
		PersonaDTO dto = new PersonaDTO();
		PersonaDao dao = new PersonaDao();
		
		for(PersonaEntity v : dao.getAllRegistro()) {
			dto = new PersonaDTO();
			dto.setIdent(v.getIdent());
			dto.setNombre(v.getNombre());
			dto.setPrimer_apellido(v.getPrimer_apellido());
			dto.setSegundo_apellido(v.getSegundo_apellido());
			dto.setTelefono(v.getTelefono());
			dto.setEstatus(v.getEstatus());
			dto.setFecha_ins(v.getFecha_ins());
			dto.setFecha_upd(v.getFecha_upd());
			dto.setActualizar("<center><button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#actualizar\" onClick=\"actu('"+ v.getIdent() +"');\">Actualizar</button></center>");
			list.add(dto);
		}
	
		return list;
	}
	
	
	public List<PersonaDTO> filtroBitacora(String idBitacora) {
		List<PersonaDTO> list = new ArrayList<PersonaDTO>();
		
		PersonaDTO dto = new PersonaDTO();
		PersonaDao dao = new PersonaDao();
		dao.getBuscador(idBitacora);
		
		
		for(PersonaDTO v : dao.getBuscador(idBitacora)) {
			dto = new PersonaDTO();
			
			dto = new PersonaDTO();
			dto.setIdent(v.getIdent());
			dto.setNombre(v.getNombre());
			dto.setPrimer_apellido(v.getPrimer_apellido());
			dto.setSegundo_apellido(v.getSegundo_apellido());
			dto.setTelefono(v.getTelefono());
			dto.setEstatus(v.getEstatus());
			dto.setFecha_ins(v.getFecha_ins());
			dto.setFecha_upd(v.getFecha_upd());
			dto.setActualizar("<center><button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#actualizar\" onClick=\"actu('"+ v.getIdent() +"');\">Actualizar</button></center>");
			list.add(dto);
		}
		
		return list;
	}
	
public void getAgregar(String nombre, String primer_apellido, String segundo_apellido, String telefono) throws ParseException{
		System.out.println("Llegamos aquí");
		PersonaDao dao = new PersonaDao();
		PersonaEntity user = new PersonaEntity();
		
		if(null == nombre) {
			nombre =" ";
		}
		if(null == primer_apellido) {
			primer_apellido =" ";
		}
		if(null == segundo_apellido) {
			segundo_apellido = " ";
		}
		if(null == telefono) {
			telefono = " ";
		}
		
		String fechaTime;
        fechaTime = new Date().getTime() + "";
        
        LocalDate feC = LocalDate.now();
        String varFeC = feC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(varFeC);
        
		user.setIdent(fechaTime);
		user.setNombre(nombre);
		user.setPrimer_apellido(primer_apellido);
		user.setSegundo_apellido(segundo_apellido);
		user.setTelefono(telefono);
		user.setFecha_ins(varFeC);
		dao.createBitacora(user);
		
	}

public void getActualizar(String nombre, String primer_apellido, String segundo_apellido, String telefono, String id) throws ParseException{
	
	PersonaDao dao = new PersonaDao();
	
	dao.bajaEstatus(nombre, primer_apellido, segundo_apellido, telefono, id);
}
	
	
	
}
