package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "tivi", 10));
        list.add(new Product(2, "tủ lạnh", 12));
        list.add(new Product(3, "máy giặt", 15));
        list.add(new Product(4, "điện thoại", 20));
        list.add(new Product(5, "máy tính", 30));
        list.add(new Product(6, "laptop", 10));
        list.add(new Product(7, "điều hòa", 8));
    }

    private static final String SELECT_ALL_PRODUCTS_QUERY = "from Product";

    @Override
    public List<Product> showList() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCTS_QUERY).getResultList();
    }

    @Override
    public void add(Product product) {

        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void edit(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            session.saveOrUpdate(product1);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.remove(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findProduct(String name) {
        String queryStr = "SELECT p FROM Product as p where p.name=:name";
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().createQuery(queryStr, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        String FIND = "SELECT p FROM Product as p where p.id=:id";
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().createQuery(FIND, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
