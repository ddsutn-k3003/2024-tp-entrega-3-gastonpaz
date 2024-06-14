package ar.edu.utn.dds.k3003.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.swing.text.html.parser.Entity;

import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.model.Temperatura;
import ar.edu.utn.dds.k3003.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HeladeraRepository {
    private EntityManagerFactory _emf;

    public HeladeraRepository() {
        _emf = Persistence.createEntityManagerFactory("dds");
    }

    public Heladera save(Heladera heladera) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(heladera);
        em.getTransaction().commit();
        em.close();
        return heladera;
    }

    public Heladera findById(Integer id) {
        EntityManager em = _emf.createEntityManager();
        Optional<Heladera> heladera = Optional.ofNullable(em.find(Heladera.class, id));
        em.close();
        return heladera.orElseThrow(() -> new NoSuchElementException(
            String.format("No hay una heladera de id: %s", id)
        ));
    }

    public void agregarVianda(Heladera heladera)
    {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        heladera.setOcupacion(heladera.getOcupacion() + 1);
        em.merge(heladera);
        em.getTransaction().commit();
        em.close();
    }

    public void retirarVianda(Heladera heladera)
    {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        heladera.setOcupacion(heladera.getOcupacion() - 1);
        em.merge(heladera);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAll() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Heladera> delete = cb.createCriteriaDelete(Heladera.class);
        delete.from(Heladera.class);
        em.createQuery(delete).executeUpdate();
        // Reiniciar los IDs
        em.createNativeQuery("ALTER SEQUENCE heladeras_id_seq RESTART WITH 1").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
