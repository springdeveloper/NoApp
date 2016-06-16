package com.app.npr.dao.genric;

import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generic JPA Repository protocol with common CRUD operations and some specific find operations
 *
 * Created by Y.Kamesh on 8/2/2015.
 */
public interface BaseJPARepository<T extends Entity, ID extends Serializable> {
    /**
     * Method to setup the class type of the Entity for which
     * the DAO works
     *
     * @param clazz
     */
    public void setupEntityClass(Class clazz);

    /**
     * Method to insert the new row into config.database table
     *
     * @param object
     *         The object entity to be persisted
     */
    public T insert(T object);

    /**
     * Method to update an existing row in the config.database table
     *
     * @param object
     *         The object entity to be updated
     */
    public T update(T object);

    /**
     * Method to insert a new row or update a row if it was
     * already existing in the system.
     *
     * @param object
     *         The object entity to be updated
     */
    public T insertOrUpdate(T object);

    /**
     * Method to delete an existing row in the config.database table
     *
     * @param object
     *         The object entity to be deleted
     */
    public void delete(T object);

    /**
     * Method to find a database item by id
     *
     * @param id
     *         The id by which the row has to be found
     */
    public T findById(ID id);
    
    public List<T> findAll();

    
    
    /**
     * Method to find a collection of database entities by pages
     *
     * @param pageNum
     * @param countPerPage
     * @param order
     *
     * @return
     *
     * @throws Exception
     */
    public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order);
    
    
    public T get(Class<T> c, Serializable id);
    public T get(String hql);
    public T get(String hql, Map<String, Object> params);
    public List<T> find(String hql);
    public List<T> find(String hql, Map<String, Object> params);
    public List<T> find(String hql, int page, int rows);
    public List<T> find(String hql, Map<String, Object> params, int page, int rows);
    public Long count(String hql);
    public Long count(String hql, Map<String, Object> params);
    public int executeHql(String hql);
    public int executeHql(String hql, Map<String, Object> params);
    public List<Object[]> findBySql(String sql);
    public List<Object[]> findBySql(String sql, int page, int rows);
    public List<Object[]> findBySql(String sql, Map<String, Object> params);
    public int executeSql(String sql, Map<String, Object> params);
    public BigInteger countBySql(String sql);
    public BigInteger countBySql(String sql, Map<String, Object> params);

	List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows);


    
    
    
    
    
    
}
