package com.cias.work.dao;

import com.cias.work.dto.PersonaDTO;
import com.cias.work.entity.PersonaEntity;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonaDao {

  public boolean createBitacora(PersonaEntity personaEntity) {
    SessionFactory factory = null;
    Session session = null;
    try {
      factory =
        new Configuration()
          .configure("hibernateDB_CIAS.cfg.xml")
          .addAnnotatedClass(PersonaEntity.class)
          .buildSessionFactory();
      session = factory.getCurrentSession();
      session.beginTransaction();
      session.save(personaEntity);
      session.flush();
      session.getTransaction().commit();

      if (null != session && session.isOpen()) {
        session.close();
      }
      if (null != factory && factory.isOpen()) {
        factory.close();
      }
    } catch (HibernateException he) {
      if (null != session.getTransaction()) {
        session.getTransaction().rollback();
      }
      if (null != session && session.isOpen()) {
        session.close();
      }
      if (null != factory && factory.isOpen()) {
        factory.close();
      }
      he.printStackTrace();
      return false;
    } catch (Exception e) {
      if (null != session.getTransaction()) {
        session.getTransaction().rollback();
      }
      if (null != session && session.isOpen()) {
        session.close();
      }
      if (null != factory && factory.isOpen()) {
        factory.close();
      }
      e.printStackTrace();
      return false;
    } finally {}
    return true;
  }

  //Obtencion de los datos de cada uno y configuracion del xml
  public List<PersonaEntity> getAllRegistro() {
    SessionFactory factory = new Configuration()
      .configure("hibernateDB_CIAS.cfg.xml")
      .addAnnotatedClass(PersonaEntity.class)
      .buildSessionFactory();
    Session session = factory.getCurrentSession();

    //obtencion de los datos en el constructor para obtener los Usuarios
    List<PersonaEntity> userList = new ArrayList<PersonaEntity>();
    try {
      session.beginTransaction();
      //ingreso al hql, uso de como se ocupa la sintaxis
      String sql = " from PersonaEntity a where a.estatus = 'Activo'";
      //creacion de la lista de usuarios en e SQL
      userList = session.createQuery(sql, PersonaEntity.class).list();

      session.flush();
      session.getTransaction().commit(); //realizara las instrucciones emitidas

      if (null != session && session.isOpen()) { //si la sesión esta abierta, esto las cerrara
        session.close();
      }

      if (null != factory && factory.isOpen()) {
        session.close();
      }
    } catch (HibernateException he) {
      if (null != session && session.isOpen()) { //
        session.close();
      }
      if (null != factory && factory.isOpen()) {
        factory.close();
      }
      he.printStackTrace();
    } catch (Exception e) {
      if (null != session && session.isOpen()) {
        session.close();
      }
      if (null != factory && factory.isOpen()) {
        factory.close();
      }
      e.printStackTrace();
    }

    return userList;
  } //ultimo corchete de public list
  
  public boolean updateUserHorasEntity(PersonaEntity personaEntity) {
		
		SessionFactory factory = null;
		Session session = null;
		
		try {
			factory = new Configuration()
					.configure("hibernateDB_CIAS.cfg.xml")
					.addAnnotatedClass(PersonaEntity.class)
					.buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.update(personaEntity);
			session.flush();
			session.getTransaction().commit();
			
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()) {
				factory.close();
			}
			//estos siempre van tanto el Hibernate como el Exception
		} catch (HibernateException he) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()) {
				factory.close();
			}
			he.printStackTrace();
			return false;
			
		} catch (Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()) {
				factory.close();
			}
			e.printStackTrace();
			return false;
		}finally {
			
		}
		
		return true;
	}//final de public boolean
  
  /*----------------------------------Hay dos maneras de hace este proceso-------------------------------*/
  public boolean bajaEstatus(String nombre, String primer_apellido, String segundo_apellido, String telefono, String id) {
	    
	    SessionFactory factory = null;
	    Session session = null;
	    try {
	        factory = new Configuration()
	                .configure("hibernateDB_CIAS.cfg.xml")
	                .addAnnotatedClass(PersonaEntity.class)
	                .buildSessionFactory();
	        session = factory.getCurrentSession();
	        session.beginTransaction();
	        String sql = "UPDATE [dbo].[Persona] set nombre = '" + nombre +"', primer_apellido = '"+primer_apellido+"', segundo_apellido = '"+segundo_apellido+"', telefono = '"+telefono+"'  where ident = '" +id+ "'";
	        Query query = session.createSQLQuery(sql);
	        query.executeUpdate();
	        session.flush();
	        session.getTransaction().commit();
	        
	        if (null != session && session.isOpen()) {
	            session.close();
	        }
	        if (null != factory && factory.isOpen()) {
	            factory.close();
	        }
	        
	    }
	    
	    catch (HibernateException he) {
	        if (null != session && session.isOpen()) {
	            session.close();
	        }
	        if (null != factory && factory.isOpen()) {
	            factory.close();
	        }
	        he.printStackTrace();
	    }
	    
	    catch (Exception e) {
	        
	        if (null != session && session.isOpen()) {
	            session.close();
	        }
	        if (null != factory && factory.isOpen()) {
	            factory.close();
	        }
	        e.printStackTrace();
	    }
	    
	    finally {
	        
	    }
	    
	    return true;
	}
  /******************************************************SE PUEDE OMITIR PONIENDO VARIOS INPUTS DE BUSQUEDA******************************************/
  @SuppressWarnings("unchecked")
	public List<PersonaDTO> getBuscador(String buscador){
		SessionFactory factory = new Configuration()
				.configure("hibernateDB_CIAS.cfg.xml")
				.addAnnotatedClass(PersonaEntity.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		PersonaDTO dto = new PersonaDTO();
		List<PersonaDTO> horasExtraList = new ArrayList <PersonaDTO>();
		
		try {
			session.beginTransaction();
			String sql = "Select a.nombre, a.primer_apellido, a.segundo_apellido, a.telefono from PersonaEntity a where a.nombre like '" + buscador + "%' or a.segundo_apellido like '" + buscador + "%'  or a.telefono like '" + buscador + "%'";
			List<Object[]> lista = session.createQuery (sql).setMaxResults(30).getResultList();
			
			for (Object[] o : lista) {
				dto = new PersonaDTO();
				dto.setNombre(o[0].toString());
				dto.setPrimer_apellido(o[1].toString());
				dto.setSegundo_apellido(o[2].toString());
				dto.setTelefono(o[3].toString());
				horasExtraList.add(dto);
			}
			
			session.flush();
			session.getTransaction().commit();
			
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()){
				factory.close();
			}
		
		
		}catch(HibernateException he) {
			
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()){
				factory.close();
			}
			
		}catch(Exception e) {
			if(null != session && session.isOpen()) {
				session.close();
			}
			if(null != factory && factory.isOpen()) {
				factory.close();
			}
			e.printStackTrace();
		}finally {
			
		}
		
		return horasExtraList;
		
	}
  
}
