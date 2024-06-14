package ar.edu.utn.dds.k3003.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ar.edu.utn.dds.k3003.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.model.Temperatura;
import java.util.NoSuchElementException;

public class TemperaturaRepository {
    private EntityManagerFactory _emf;

    public TemperaturaRepository() {
        _emf = Persistence.createEntityManagerFactory("dds");
    }

    public Temperatura save(Temperatura temperatura) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(temperatura);
        em.getTransaction().commit();
        em.close();
        return temperatura;
    }

    public Temperatura findById(Long id) {
        EntityManager em = _emf.createEntityManager();
        Optional<Temperatura> temperatura = Optional.ofNullable(em.find(Temperatura.class, id));
        em.close();
        return temperatura.orElseThrow(() -> new NoSuchElementException(
            String.format("No hay una temperatura de id: %s", id)
        ));
    }

    public Collection<Temperatura> findByheladeraId(Integer heladeraId) {
        EntityManager em = _emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Temperatura> cq = cb.createQuery(Temperatura.class);
        Root<Temperatura> temperatura = cq.from(Temperatura.class);
        cq.select(temperatura)
          .where(cb.equal(temperatura.get("heladeraId"), heladeraId))
          .orderBy(cb.desc(temperatura.get("fecha")));
        Collection<Temperatura> temperaturas = em.createQuery(cq).getResultList();
        em.close();
        return temperaturas;
    }

    public void deleteAll() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Temperatura> delete = cb.createCriteriaDelete(Temperatura.class);
        delete.from(Temperatura.class);
        em.createQuery(delete).executeUpdate();
        // Reiniciar los IDs
        em.createNativeQuery("ALTER SEQUENCE heladeras_id_seq RESTART WITH 1").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
