package testPackage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.joda.time.DateTime;

/**
 *
 * @author Łukasz
 */
public class Queries {
        public static void printStandardowe(Session session){
        System.out.println("****************Standardowe*********************");
        System.out.println("1.Nazwy i opisy projektow ktore zaczely sie po 1 stycznia 2012");
        Query query = session.createQuery("SELECT new map (P.nazwa AS Nazwa, P.opis AS Opis) FROM Projekt P WHERE P.dataPocz >= :dataPocz");
        DateTime dateTime = new DateTime(2012, 1, 1, 0, 0);
        query.setDate("dataPocz", dateTime.toDate());
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }
        System.out.println("\n2.Nazwisko osoby ktora jest kierownikiem projektu MPZproj");
        query = session.createQuery("SELECT k.nazwisko AS Nazwisko FROM Kierownik k inner join k.projekty as p WHERE p.nazwa = :nazwa ");
        query.setParameter("nazwa", "MPZproj");
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }
        System.out.println("\n3.Nazwisko osoby ktora jest kierownikiem projektu MPZproj");
        query = session.createQuery("SELECT p.zapotrzebowanie.jezykProg FROM Projekt p WHERE p.kierownik.nazwisko = :nazwisko");
        query.setParameter("nazwisko", "Bielecki");
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }
    }
    public static void printKryterialne(Session session){
        System.out.println("****************Kryterialne*********************");
    }
    
}
