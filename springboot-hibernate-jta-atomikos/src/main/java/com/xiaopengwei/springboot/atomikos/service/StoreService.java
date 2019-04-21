package com.xiaopengwei.springboot.atomikos.service;

import com.xiaopengwei.springboot.atomikos.entity.customer.Customer;
import com.xiaopengwei.springboot.atomikos.entity.order.Order;
import com.xiaopengwei.springboot.atomikos.exception.NoRollbackException;
import com.xiaopengwei.springboot.atomikos.exception.StoreException;

/**
 * <p>
 *   业务逻辑层接口
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-13
 */
public interface StoreService {
	
	void store(Customer customer, Order order) throws Exception;
	
	void storeWithStoreException(Customer customer, Order order) throws StoreException;
	
	void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException;
	
	void transferWithStoreException() throws StoreException;
	void transferWithNoRollbackException() throws NoRollbackException;
	void transfer();

}
