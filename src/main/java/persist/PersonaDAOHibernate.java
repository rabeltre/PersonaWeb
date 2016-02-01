/*
 * ContactosDAO.java
 *
 * Creada el 26-ago-2010, 14:23:39
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.blogspot.com/ el día 26-ago-2010
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 */

package persist;


import java.util.List;
import model.Persona;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("personaDao")
public class PersonaDAOHibernate implements PersonaDAO
{
    public SessionFactory sessionFactory;



@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Persona findByUuid(String uuid) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(String s) {
        Session session= sessionFactory.getCurrentSession();
        return   (Persona)session.load(Persona.class, s);

    }
    @Override
    @Transactional(readOnly = true)
    public Persona find(String id){
        Session session= sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", id));
        return (Persona) criteria.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        Session session= sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Persona.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Persona makePersistent(Persona entity) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional
    public void makeTransient(Persona entity) {
        Session session= sessionFactory.getCurrentSession();
        session.delete(entity);
    }


   /* private Session sesion;
    private Transaction tx;  
    private static PersonaDAOHibernate instance = null;
    private static final int STATUS_ENABLE=1;
    private static StatusDAOHibernate statusDAO;

    

    
    public void guardaContacto(Persona contacto) throws HibernateException 
    { 
        

        try 
        { 
           // iniciaOperacion();
            this.makePersistent(contacto);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        
    }  

    
    public void actualizaContacto(Persona contacto) throws HibernateException 
    { 
        try 
        { 
           // iniciaOperacion();
            sesion.update(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void eliminaContacto(Persona contacto) throws HibernateException 
    { 
        try 
        { 
            //iniciaOperacion();
            contacto.setStatus(statusDAO.findById(2));
            sesion.saveOrUpdate(contacto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  
    

 *//*   private void iniciaOperacion() throws HibernateException
    { 
        sesion = HibernateUtil.getSessionFactory().openSession();
      tx = sesion.beginTransaction();
    }  *//*

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 

    @Override
    public Persona findByUuid(String uuid) {
        
       // iniciaOperacion();
        Criteria criteria = sesion.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", uuid));
        return (Persona) criteria.uniqueResult();
    }


    @Override
    public List<Persona> findAll() {
          try 
        { 
           // iniciaOperacion();
        Criteria criteria = sesion.createCriteria(Persona.class, "p");
        criteria.createAlias("status", "s");
        criteria.setReadOnly(true);
        criteria.add(Restrictions.eq("s.id", STATUS_ENABLE));
        return criteria.list(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
        
    }

    @Override
    public Persona makePersistent(Persona entity) {
        try 
        { 
       // iniciaOperacion();
            sesion.saveOrUpdate(entity);
            tx.commit();
            
            return entity;
            } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }

    @Override
    public void makeTransient(Persona entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona findById(String id) {
        //iniciaOperacion();
        Criteria criteria = sesion.createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", id));
        return (Persona) criteria.uniqueResult();
    }
    */



    
}
