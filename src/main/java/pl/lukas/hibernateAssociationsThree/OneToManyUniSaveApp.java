package pl.lukas.hibernateAssociationsThree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.lukas.hibernateAssociationsThree.entity.*;

public class OneToManyUniSaveApp {

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
        Company company = session.get(Company.class, id);
        System.out.println(company);

        Department departmentOne = new Department("Sales");
        Department departmentTwo = new Department("Production");
        Department departmentThree = new Department("HR");

        company.addDepartment(departmentOne);
        company.addDepartment(departmentTwo);
        company.addDepartment(departmentThree);

        session.persist(company);



        session.getTransaction().commit();

        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
