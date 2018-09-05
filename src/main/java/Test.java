import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Student student = new Student();
        student.setName("Ahmet");
        student.setSurname("Acar");
        session.save(student);

        Course course1 = new Course();
        course1.setCourseName("Matematik");
        course1.setStudent(student);
        session.save(course1);

        Course course2 = new Course();
        course2.setCourseName("Fizik");
        course2.setStudent(student);
        session.save(course2);

        Course course3 = new Course();
        course3.setCourseName("Kimya");
        course3.setStudent(student);
        session.save(course3);

        session.getTransaction().commit();
        session.close();


        session = sessionFactory.openSession();

        // List<Student> studentList = session.createQuery("from Student s left join fetch s.courses cs").getResultList();

        List<Student> studentList = session.createQuery("from Student s").getResultList();

        System.out.println("Student name => " + studentList.get(0).getName());
        System.out.println("Student surname => " + studentList.get(0).getSurname());
        // System.out.println("Student courses => " + studentList.get(0).getCourses());

        session.close();

        System.out.println("session is close...");

        System.out.println("Student name => " + studentList.get(0).getName());
        System.out.println("Student surname => " + studentList.get(0).getName());
        System.out.println("Student courses => " + studentList.get(0).getCourses());
    }

}
