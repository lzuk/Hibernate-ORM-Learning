package testPackage;

import classesAnn.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestClassAnn {

    private static final SessionFactory SESSION_FACTORY;

    static {
        Configuration config = new Configuration().configure();
        config.setProperty("hibernate.show_sql", "false");
        config.addAnnotatedClass(Jezyk.class);
        config.addAnnotatedClass(JezykProg.class);
        config.addAnnotatedClass(Kierownik.class);
        config.addAnnotatedClass(Osoba.class);
        config.addAnnotatedClass(Programista.class);
        config.addAnnotatedClass(Projekt.class);
        config.addAnnotatedClass(Zapotrzebowanie.class);
        config.addAnnotatedClass(Zatrudnienie.class);

        ServiceRegistryBuilder registryBuilder = new ServiceRegistryBuilder();
        registryBuilder.applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = registryBuilder.buildServiceRegistry();
        SESSION_FACTORY = config.buildSessionFactory(serviceRegistry);
    }

    private static void createProjekt() {
        Session session = SESSION_FACTORY.openSession();
        Transaction tx = session.beginTransaction();
        Projekt projekt = new Projekt();
        projekt.setNazwa("MPZproj");
        projekt.setOpis("MPZ desc");
        projekt.setDataPocz(Calendar.getInstance());
        projekt.setDataKon(Calendar.getInstance());
        Kierownik kierownik = new Kierownik();
        kierownik.setImie("Arek");
        kierownik.setNazwisko("Bielecki");
        projekt.setKierownik(kierownik);
        Set<Projekt> projekty = new HashSet<Projekt>();
        kierownik.setProjekty(projekty);
        Zatrudnienie zatrudnienie = new Zatrudnienie();
        zatrudnienie.setProjekt(projekt);
        Programista programista = new Programista();
        programista.setNazwisko("Gates");
        zatrudnienie.setProgramista(programista);
        Set<Zatrudnienie> zatrudnienieP = new HashSet<Zatrudnienie>();
        zatrudnienieP.add(zatrudnienie);
        programista.setZatrudnienie(zatrudnienieP);
        projekt.setZatrudnienie(zatrudnienieP);
        Jezyk jezyk = new Jezyk();
        jezyk.setProgramista(programista);
        jezyk.setStopienZnaj(80);
        JezykProg jezykProg = new JezykProg();
        jezykProg.setNazwa("SiSzarp");
        jezyk.setJezykProg(jezykProg);
        Set<Jezyk> jezyki = new HashSet<Jezyk>();
        jezyki.add(jezyk);
        programista.setJezyki(jezyki);
        Zapotrzebowanie zapotrzebowanie = new Zapotrzebowanie();
        zapotrzebowanie.setJezykProg(jezykProg);
        zapotrzebowanie.setProjekt(projekt);
        zapotrzebowanie.setStonienZnaj(70);
        zapotrzebowanie.setOsoboGodz(30);
        Set<Zapotrzebowanie> zapotrzebowanieP = new HashSet<Zapotrzebowanie>();
        zapotrzebowanieP.add(zapotrzebowanie);
        projekt.setZapotrzebowanie(zapotrzebowanieP);

        session.save(projekt);
        tx.commit();
        session.close();
    }


    public static void main(String[] args) {
        //createProjekt();
        Session session = SESSION_FACTORY.openSession();
        Queries.printHQL(session);

        Queries.printKryterialne(session);
        session.close();
    }

}
