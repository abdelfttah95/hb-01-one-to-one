package src;

import entity.InstructorDetail;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class GetInstructorDetail {

    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            int theId = 1;
            InstructorDetail tempInstructorDetail
                    = (InstructorDetail) session.get(InstructorDetail.class, theId);

            System.out.println("tempInstrucorDetail : " + tempInstructorDetail);
            
            System.out.println("the associated Instructor : "
                    + tempInstructorDetail.getInstructor());
            
            session.getTransaction().commit();
            System.out.println("Done.");
        } catch (Exception e) {
        }
    }
}
