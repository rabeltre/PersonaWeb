/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import java.util.List;
import model.Persona;
import model.Status;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hterrero
 */
public class StatusDAOHibernate implements StatusDAO {
    
    private Session sesion; 
    private Transaction tx;  
    private static StatusDAOHibernate instance = null;
    
    public static StatusDAOHibernate getInstance(){
        if (instance==null)
            instance = new StatusDAOHibernate();
        return instance;
    }
    
     private void iniciaOperacion() throws HibernateException 
    { 
       // sesion = HibernateUtil.getSessionFactory().openSession();
      //  tx = sesion.beginTransaction();
    }

    @Override
    public Status findById(String id) {
        iniciaOperacion(); 
        Criteria criteria = sesion.createCriteria(Status.class);
        criteria.add(Restrictions.eq("id", id));
        return (Status) criteria.uniqueResult();
    }

    @Override
    public List<Status> findAll() {
        Criteria criteria = sesion.createCriteria(Persona.class);
        criteria.setReadOnly(true);
        return criteria.list();
    }

    @Override
    public Status makePersistent(Status entity) {
        iniciaOperacion(); 
            sesion.saveOrUpdate(entity);
            tx.commit();
            
            return entity;
    }

    @Override
    public void makeTransient(Status entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Status findById(int id) {
            iniciaOperacion(); 
        Criteria criteria = sesion.createCriteria(Status.class);
        criteria.add(Restrictions.eq("id", id));
        return (Status) criteria.uniqueResult();
    }
    
}
