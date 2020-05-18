package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;

@Repository
public class  EstudianteDAOImpl implements EstudianteDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb= new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query =entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante> resulset=query.getResultList();
		
		return resulset;
	}

	
	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException{
		if(estudiante.getC_usuario() == null) { //Si la propiedad de la llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(estudiante); //Utilizamos persist ya que es un INSERT
		}
		else { //Caso contrario, se busco al cliente, por lo que la propiedad ccliente viene llena (el input hidden del formulario)
			entityManager.merge(estudiante); //Utilizamos merge ya que es un UPDATE
		}
	}


}
