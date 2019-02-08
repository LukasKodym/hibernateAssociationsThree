package pl.lukas.hibernateAssociationsThree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernateAssociationsThree.entity.Company;
import pl.lukas.hibernateAssociationsThree.entity.CompanyDetail;
import pl.lukas.hibernateAssociationsThree.entity.Department;
import pl.lukas.hibernateAssociationsThree.entity.Property;

public class OneToManyUniGetApp {

    public static void main(String[] args) {
        // tworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacje klasy
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        // tworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobieranie sesji
        Session session = factory.getCurrentSession();

        int id = 35;

        session.beginTransaction();
//        Company company = session.get(Company.class, id);
//        System.out.println(company);
//
//        Set<Department> departments = company.getDepartments();
//
//        for (Department department : departments) {
//            System.out.println(department);
//        }

        Department department = session.get(Department.class, 1);

        System.out.println(department);

        session.getTransaction().commit();

        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
