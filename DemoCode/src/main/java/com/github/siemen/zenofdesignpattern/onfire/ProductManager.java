package com.github.siemen.zenofdesignpattern.onfire;
/**
 * Created by Zhan on 2017-04-18.
 */


/**
 * 产品管理类：产品工厂-产品和事件的桥梁
 * 单来源调用：只能由工厂类来调用产生产品类实例
 */
public class ProductManager {
    private boolean isPermittedCreate = false;

    public  Product createProduct(String name){
        this.isPermittedCreate = true;
        Product product = new Product(this,name);
        new ProductEvent(product,ProductEventType.NEW_PRODUCT);
       return product;
    }

    public   void abandonProduct(Product product){

        new ProductEvent(product,ProductEventType.DEL_PRODUCT);
        product = null;
    }

    public  void editProduct(Product product,String name){
        product.setName(name);
        new ProductEvent(product,ProductEventType.EDIT_PRODUCT);
    }

    public  boolean isCreateProduct(){
        return isPermittedCreate;
    }

    public  Product clone(Product product){
        new ProductEvent(product,ProductEventType.CLONE_PRODUCT);
        return  product.clone();
    }
}
