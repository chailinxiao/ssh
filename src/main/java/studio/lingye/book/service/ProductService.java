package studio.lingye.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.lingye.book.dao.ProductDao;
import studio.lingye.book.entity.Product;

@Service
public class ProductService  {

    @Autowired
    private ProductDao productDao;

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

}
