package org.lab1.data;

import org.lab1.data.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.stream.Location;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CRUD {
    static String persistenceName = "myPersistenceUnit";

    public static void update(Object o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void add(Object o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void delete(Object o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(o));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static <T> T find(Class<T> classname, long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        T res;
        try {
            em.getTransaction().begin();
            res = em.find(classname, id);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        return res;
    }

    public static User getUserByLogin(String login) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        List<User> res;
        try {
            em.getTransaction().begin();
            res = em.createQuery("select o from org.lab1.data.entity.User o where o.login = \"" + login + "\"").getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        if (res.isEmpty())
            return null;
        return res.get(0);
    }

    public static <T> List<T> findAll(Class<T> classname) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        List<T> res;
        try {
            em.getTransaction().begin();
            res = em.createQuery("select o from " + classname.getName() + " o order by o.id").getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        return res;
    }

    private static void refresh(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        emf.getCache().evictAll();
        emf.close();
    }

//    private static void executeProcedure(String procedure) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.createNativeQuery("CALL " + procedure + ";").executeUpdate();
//        em.clear();
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//
//        refresh();
//    }
//
//    public static void executeScript(String script){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery(script);
//        q.executeUpdate();
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
//
//    private static List<BookCreature> executeFunction(String function) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        List<BookCreature> res = em.createNativeQuery("SELECT * FROM " + function + ";", "bookCreatureMapping").getResultList();
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        return res;
//    }


    public static int getNumberOfLessVenueTickets(int minVenue) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        int res;
        try {
            em.getTransaction().begin();
            res = em.createNativeQuery("SELECT COUNT(*) FROM getNumberOfLessVenueTickets(" + minVenue + ");").executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        return res;
    }

    public static int getNumberOfMoreNumberTickets(int maxNumber) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        int res;
        try {
            em.getTransaction().begin();
            res = em.createNativeQuery("SELECT COUNT(*) FROM getNumberOfMoreNumberTickets(" + maxNumber + ");").executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        return res;
    }

    public static List<Ticket> getTicketsWithGreaterNumber(int maxNumber) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        List<Ticket> res;
        try {
            em.getTransaction().begin();
            res = em.createNativeQuery("SELECT * FROM getTicketsWithGreaterNumber(" + maxNumber + ");", "ticketMapping").getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
        return res;
    }

    public static void copyVIPTicket(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("SELECT copyVIPTicket(" + id + ");").executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void copyDiscountTicket(int id, int discount) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("SELECT copyDiscountTicket(" + id + discount + ");").executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }


    public static <T> List<Ticket> findTicketByClassId(Class<T> classname, long id) {
        return findAll(Ticket.class).stream().filter(ticket -> {
            if (Coordinates.class.equals(classname)) {
                return ticket.getCoordinates().getId() == id;
            } else if (Venue.class.equals(classname)) {
                return ticket.getVenue().getId() == id;
            } else if (Event.class.equals(classname)) {
                return ticket.getEvent().getId() == id;
            }
            return false;
        }).collect(Collectors.toList());
    }
}
