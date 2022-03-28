/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.Estudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Camilo Gomez
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
}
