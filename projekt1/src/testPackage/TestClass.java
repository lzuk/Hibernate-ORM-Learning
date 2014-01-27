package testPackage;

import classes.Jezyk;
import classes.JezykProg;
import classes.Kierownik;

import java.io.File;
import java.util.*;

import classes.Osoba;
import classes.Programista;
import classes.Projekt;
import classes.Zapotrzebowanie;
import classes.Zatrudnienie;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//JodaTime
import org.joda.time.DateTime;

public class TestClass {
	private static final SessionFactory SESSION_FACTORY;

    static {
        File mappingDir = new File("src\\mapping");
        Configuration config = new Configuration().configure();
        config.setProperty("hibernate.show_sql", "false");
        config.addDirectory(mappingDir);

        ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
        registryBuilder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = registryBuilder.buildServiceRegistry();
        SESSION_FACTORY = config.buildSessionFactory(serviceRegistry);
    }
    
    private static void createOsoby() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        Osoba o1 = new Osoba();
        o1.setImie("Jan");
        o1.setNazwisko("Kowalski");
        session.save(o1);
        Osoba o2 = new Osoba();
        o2.setImie("Tomasz");
        o2.setNazwisko("Barański");
        session.save(o2);
        tx.commit();
        session.close();
    }
    private static void createProjekt(){
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        Projekt projekt = new Projekt();
        projekt.setNazwa("IORproj");
        projekt.setOpis("IOR desc");
        projekt.setDataPocz(Calendar.getInstance());
        projekt.setDataKon(Calendar.getInstance());
        Kierownik kierownik = new Kierownik();
        kierownik.setImie("Adolf");
        kierownik.setNazwisko("Wilecki");
        projekt.setKierownik(kierownik);
        Set<Projekt> projekty = new HashSet<Projekt>();
        kierownik.setProjekty(projekty);
        Zatrudnienie zatrudnienie = new Zatrudnienie();
        zatrudnienie.setProjekt(projekt);
        Programista programista = new Programista();
        programista.setNazwisko("Jazzz");
        zatrudnienie.setProgramista(programista);
        Set<Zatrudnienie> zatrudnienieP = new HashSet<Zatrudnienie>();
        zatrudnienieP.add(zatrudnienie);
        programista.setZatrudnienie(zatrudnienieP);
        projekt.setZatrudnienie(zatrudnienieP);
        Jezyk jezyk = new Jezyk();
        jezyk.setProgramista(programista);
        jezyk.setStopienZnaj(75);
        JezykProg jezykProg = new JezykProg();
        jezykProg.setNazwa("Dzawa");
        jezyk.setJezykProg(jezykProg);
        Set<Jezyk> jezyki = new HashSet<Jezyk>();
        jezyki.add(jezyk);
        programista.setJezyki(jezyki);
        Zapotrzebowanie zapotrzebowanie = new Zapotrzebowanie();
        zapotrzebowanie.setJezykProg(jezykProg);
        zapotrzebowanie.setProjekt(projekt);
        zapotrzebowanie.setStonienZnaj(50);
        zapotrzebowanie.setOsoboGodz(40);
        Set<Zapotrzebowanie> zapotrzebowanieP = new HashSet<Zapotrzebowanie>();
        zapotrzebowanieP.add(zapotrzebowanie);
        projekt.setZapotrzebowanie(zapotrzebowanieP);
        
        session.save(projekt);
        tx.commit();
        session.close();
    }    
    
    public static void main(String [] args)
    {
    	//createOsoby();
        //createProjekt();
        Session session = SESSION_FACTORY.openSession();
        printStandardowe(session);
        
        printKryterialne(session);            
        session.close();
    }
    private static void printStandardowe(Session session){
        System.out.println("****************Standardowe*********************");
        System.out.println("Nazwy i opisy projektow ktore zaczely sie po 1 stycznia 2012");
        Query query = session.createQuery("SELECT new map (P.nazwa AS Nazwa, P.opis AS Opis) FROM Projekt P WHERE P.dataPocz >= :dataPocz");
        DateTime dateTime = new DateTime(2012, 1, 1, 0, 0);
        query.setDate("dataPocz", dateTime.toDate());
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }
        System.out.println("Nazwisko osoby ktora jest kierownikiem projektu MPZproj");
        query = session.createQuery("SELECT k.nazwisko AS Nazwisko FROM Kierownik k inner join k.projekty as p WHERE p.nazwa = :nazwa ");
        query.setParameter("nazwa", "MPZproj");
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }

        query = session.createQuery("SELECT p.zapotrzebowanie.jezykProg FROM Projekt p WHERE p.kierownik.nazwisko = :nazwisko");
        query.setParameter("nazwisko", "Bielecki");
            for (Object obj : query.list()) {
                System.out.println(obj.toString());
            }
    }
    
    private static void printKryterialne(Session session){
        System.out.println("****************Kryterialne*********************");
    }
}
