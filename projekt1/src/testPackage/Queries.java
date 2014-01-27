package testPackage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

/**
 * @author Łukasz
 */
public class Queries {

    public static void printHQL(Session session) {
        System.out.println("****************Standardowe*********************");
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

    public static void printKryterialne(Session session) {
        System.out.println("****************Kryterialne*********************");
    }

}
