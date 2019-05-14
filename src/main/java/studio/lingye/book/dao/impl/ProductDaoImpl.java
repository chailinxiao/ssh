package studio.lingye.book.dao.impl;

import javax.xml.registry.infomodel.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import studio.lingye.book.dao.ProductDao;
import studio.lingye.book.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	private HibernateTemplate template;
	
    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveProduct(final Product product) {
    	
    	template.execute(new HibernateCallback<Product>() {
			

			@Override
			public Product doInHibernate(Session session) throws HibernateException {
				session.save(product);
				return null;
			}
    	});

    	
//        template.save(product);
    }
	
}
