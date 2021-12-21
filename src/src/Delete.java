package src;

import entity.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class Delete {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            int theId = 2;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, theId);
            
            if (tempInstructor != null) {
                System.out.println("Deleting ... " + tempInstructor);
                session.delete(tempInstructor);
            } 
            
            session.getTransaction().commit();
            System.out.println("Done.!");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
