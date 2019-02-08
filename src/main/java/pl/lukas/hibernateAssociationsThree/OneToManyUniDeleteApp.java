package pl.lukas.hibernateAssociationsThree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.lukas.hibernateAssociationsThree.entity.Company;
import pl.lukas.hibernateAssociationsThree.entity.CompanyDetail;
import pl.lukas.hibernateAssociationsThree.entity.Department;
import pl.lukas.hibernateAssociationsThree.entity.Property;

public class OneToManyUniDeleteApp {

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

        int id = 2;
        int idCompany = 35;
        String departmentNameToDelete = "HR";
        int idHql = 3;

        String delete = "delete Department d where d.idDepartment=:idDepartment";

        session.beginTransaction();


//        Department department = session.get(Department.class, id);
//        session.delete(department);

//        Company company = session.get(Company.class, idCompany);
//
//        for (Department department : company.getDepartments()) {
//            if(department.getName().equals(departmentNameToDelete)){
//                company.getDepartments().remove(department);
//                session.delete(department);
//            }
//        }

        Query query = session.createQuery(delete);
        query.setParameter("idDepartment", idHql);
        int deletedRows = query.executeUpdate();
        System.out.println("ilość usuniętych rekordów: " + deletedRows);

        session.getTransaction().commit();

        // zakończeine obiektu SessionFactory
        factory.close();
    }
}
