package testPackage;

import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

/**
 * @author Łukasz
 */
public class Queries {

    public static void printHQL(Session session) {
        System.out.println("****************Zapytania HQL******************");
        System.out.println("1.Nazwy i opisy projektow ktore zaczely sie po 1 stycznia 2012");
        Query query = session.createQuery("SELECT new map (P.nazwa AS Nazwa, P.opis AS Opis) FROM Projekt P WHERE P.dataPocz >= :dataPocz");
        DateTime poczatek2012 = new DateTime(2012, 1, 1, 0, 0);
        query.setDate("dataPocz", poczatek2012.toDate());
        for (Object obj : query.list()) {
            System.out.println(obj.toString());
        }
        System.out.println("\n2.Nazwisko osoby ktora jest kierownikiem projektu MPZproj");
        query = session.createQuery("SELECT k.nazwisko AS Nazwisko FROM Kierownik k inner join k.projekty as p WHERE p.nazwa = :nazwa ");
        query.setParameter("nazwa", "MPZproj");
        for (Object obj : query.list()) {
            System.out.println(obj.toString());
        }
        System.out.println("\n3.Ilość Projektów które zostały całkowicie przeprowadzone (rozpoczete i zakonczone) w 2013 roku");
        query = session.createQuery("SELECT COUNT(p) FROM Projekt p WHERE p.dataPocz >= :dataPocz AND p.dataKon <= :dataKon");
        DateTime poczatek2013 = new DateTime(2012, 1, 1, 0, 0);
        DateTime koniec2013 = new DateTime(2013, 12, 31, 23, 59);
        query.setDate("dataPocz", poczatek2013.toDate());
        query.setDate("dataKon", koniec2013.toDate());
        System.out.println("Ilość projektów: " + query.list().get(0));
    }

    public static void printKryterialne(Session session, QueryType queryType) {
        System.out.println("\n****************Kryterialne*********************");
        
        Criteria criteria1 = null;
        Criteria criteria2 = null;
        Criteria criteria3 = null;
        //***********************Zapytanie 1**********************************
        switch (queryType ){
            case Annotations:
                System.out.println("****************Mapowania Adnotacyjne*******************");
                criteria1 = session.createCriteria(classesAnn.Projekt.class);
                break;
            case XML:
                System.out.println("****************Mapowania XML*******************");
                criteria1 = session.createCriteria(classes.Projekt.class);
                break;
            default:
                return;
        }
             ProjectionList proList = Projections.projectionList();
             proList.add(Projections.property("nazwa"));
             proList.add(Projections.property("opis"));
                     
             DateTime poczatek2012 = new DateTime(2012, 1, 1, 0, 0);
             criteria1 = criteria1.add(Restrictions.ge("dataPocz", poczatek2012.toCalendar(null)));
             criteria1 = criteria1.setProjection(proList);
        
        System.out.println("1.Nazwy i opisy projektow ktore zaczely sie po 1 stycznia 2012");
        Iterator it = criteria1.list().iterator();
        while(it.hasNext()){
            Object[] obj = (Object[]) it.next();
            System.out.println("Nazwa: " + obj[0]+ ", Opis: " + obj[1]);
        }
        
        //***********************Zapytanie 2**********************************
        System.out.println("\n2.Nazwisko osoby ktora jest kierownikiem projektu MPZproj");
        switch (queryType ){
            case Annotations:
                criteria2 = session.createCriteria(classesAnn.Kierownik.class);
                break;
            case XML:
                criteria2 = session.createCriteria(classes.Kierownik.class);
                break;
            default:
                return;
        }
        criteria2 = criteria2.createAlias("projekty", "p");
        criteria2 = criteria2.add(Restrictions.like("p.nazwa", "MPZproj"));
        criteria2 = criteria2.setProjection(Projections.property("nazwisko"));
        
        System.out.println(criteria2.list().get(0));
        
        
        
        //***********************Zapytanie 3**********************************
        System.out.println("\n3.Ilość Projektów które zostały całkowicie przeprowadzone (rozpoczete i zakonczone) w 2013 roku");
        switch (queryType ){
            case Annotations:
                criteria3 = session.createCriteria(classesAnn.Projekt.class);
                break;
            case XML:
                criteria3 = session.createCriteria(classes.Projekt.class);
                break;
            default:
                return;
        }

        DateTime poczatek2013 = new DateTime(2013, 1, 1, 0, 0);
        DateTime koniec2013 = new DateTime(2013, 12, 31, 23, 59);
        
        criteria3 = criteria3.add(Restrictions.between("dataPocz", poczatek2013.toCalendar(null), koniec2013.toCalendar(null)));
        
        System.out.println("Ilość projektów: " + criteria3.list().size());    
    }
    public enum QueryType{
        XML,
        Annotations
    }
}
