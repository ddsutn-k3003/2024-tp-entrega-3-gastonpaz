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

import ar.edu.utn.dds.k3003.model.Operacion;
import ar.edu.utn.dds.k3003.model.Temperatura;
import ar.edu.utn.dds.k3003.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperacionRepository {
    private EntityManagerFactory _emf;

    public OperacionRepository() {
        _emf = Persistence.createEntityManagerFactory("dds");
    }

    public Operacion save(Operacion operacion) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(operacion);
        em.getTransaction().commit();
        em.close();
        return operacion;
    }

    public Operacion findById(Long id) {
        EntityManager em = _emf.createEntityManager();
        Optional<Operacion> operacion = Optional.ofNullable(em.find(Operacion.class, id));
        em.close();
        return operacion.orElseThrow(() -> new NoSuchElementException(
            String.format("No hay una operacion de id: %s", id)
        ));
    }

    public void deleteAll() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Operacion> delete = cb.createCriteriaDelete(Operacion.class);
        delete.from(Operacion.class);
        em.createQuery(delete).executeUpdate();
        // Reiniciar los IDs
        em.createNativeQuery("ALTER SEQUENCE heladeras_id_seq RESTART WITH 1").executeUpdate();
        em.getTransaction().commit();
        em.close();

    }
}
