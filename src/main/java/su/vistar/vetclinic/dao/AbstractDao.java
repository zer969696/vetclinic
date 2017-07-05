package su.vistar.vetclinic.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import su.vistar.vetclinic.model.Client;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Evgeniy Evzerov on 14.02.17.
 * VIstar
 */
public class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistenceClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistenceClass = (Class<T>) (
                (ParameterizedType) this.getClass().getGenericSuperclass()
        ).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(PK key) {
        return (T) getSession().get(persistenceClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public <T> T initializeAndUnProxy(T entity) {
        Hibernate.initialize(entity);
        Object unproxied = ((SessionImplementor)getSession()).getPersistenceContext().unproxy(entity);

        return (T) unproxied;
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistenceClass);
    }
}
