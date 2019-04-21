package com.xiaopengwei.springboot.atomikos.service.impl;

import java.math.BigDecimal;

import com.xiaopengwei.springboot.atomikos.service.StoreService;
import com.xiaopengwei.springboot.atomikos.exception.NoRollbackException;
import com.xiaopengwei.springboot.atomikos.exception.StoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaopengwei.springboot.atomikos.entity.customer.CapitalAccount;
import com.xiaopengwei.springboot.atomikos.entity.customer.Customer;
import com.xiaopengwei.springboot.atomikos.entity.order.Order;
import com.xiaopengwei.springboot.atomikos.entity.order.RedPacketAccount;
import com.xiaopengwei.springboot.atomikos.repository.customer.CapitalAccountRepository;
import com.xiaopengwei.springboot.atomikos.repository.customer.CustomerRepository;
import com.xiaopengwei.springboot.atomikos.repository.order.OrderRepository;
import com.xiaopengwei.springboot.atomikos.repository.order.RedPacketAccountRepository;

/**
 * <p>
 * 示例操作的业务逻辑层实现
 * </p>
 *
 * @author XiaoPengwei.com
 * @since 2019-04-04
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    CapitalAccountRepository capitalAccountRepository;

    @Autowired
    RedPacketAccountRepository redPacketAccountRepository;

    @Override
    @Transactional
    public void store(Customer customer, Order order) {
        customerRepository.save(customer);
        orderRepository.save(order);
    }

    @Transactional(rollbackFor = StoreException.class)
    @Override
    public void storeWithStoreException(Customer customer, Order order) throws StoreException {
        customerRepository.save(customer);
        orderRepository.save(order);
        throw new StoreException();
    }

    @Transactional(noRollbackFor = NoRollbackException.class, rollbackFor = StoreException.class)
    @Override
    public void storeWithNoRollbackException(Customer customer, Order order) throws NoRollbackException {
        customerRepository.save(customer);
        orderRepository.save(order);
        throw new NoRollbackException();
    }

    @Transactional()
    public void transfer() {
        CapitalAccount ca1 = capitalAccountRepository.findOne(1l);
        CapitalAccount ca2 = capitalAccountRepository.findOne(2l);
        RedPacketAccount rp1 = redPacketAccountRepository.findOne(1l);
        RedPacketAccount rp2 = redPacketAccountRepository.findOne(2l);
        BigDecimal capital = BigDecimal.TEN;
        BigDecimal red = BigDecimal.TEN;
        ca1.transferFrom(capital);
        ca2.transferTo(capital);
        capitalAccountRepository.save(ca1);
        capitalAccountRepository.save(ca2);
//		if (rp2.getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
//			throw new RuntimeException("账号异常");
//		}
        rp2.transferFrom(red);
        rp1.transferTo(red);
        redPacketAccountRepository.save(rp1);
        redPacketAccountRepository.save(rp2);

    }

    @Transactional(rollbackFor = StoreException.class)
    public void transferWithStoreException() throws StoreException {
        CapitalAccount ca1 = capitalAccountRepository.findOne(1l);
        CapitalAccount ca2 = capitalAccountRepository.findOne(2l);
        RedPacketAccount rp1 = redPacketAccountRepository.findOne(1l);
        RedPacketAccount rp2 = redPacketAccountRepository.findOne(2l);

        BigDecimal capital = BigDecimal.TEN;
        BigDecimal red = BigDecimal.TEN;

        ca1.transferFrom(capital);
        ca2.transferTo(capital);
        capitalAccountRepository.save(ca1);
        capitalAccountRepository.save(ca2);
//		if (rp2.getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
//			throw new RuntimeException("账号异常");
//		}
//		if (rp2.getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
//			throw new IllegalArgumentException("账号异常");
//		}
        if (rp2.getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new StoreException();
        }
        rp2.transferFrom(red);
        rp1.transferTo(red);
        redPacketAccountRepository.save(rp1);
        redPacketAccountRepository.save(rp2);

    }

    @Transactional(noRollbackFor = NoRollbackException.class, rollbackFor = StoreException.class)
    public void transferWithNoRollbackException() throws NoRollbackException {
        CapitalAccount ca1 = capitalAccountRepository.findOne(1l);
        CapitalAccount ca2 = capitalAccountRepository.findOne(2l);
        RedPacketAccount rp1 = redPacketAccountRepository.findOne(1l);
        RedPacketAccount rp2 = redPacketAccountRepository.findOne(2l);

        BigDecimal capital = BigDecimal.TEN;
        BigDecimal red = BigDecimal.TEN;

        ca1.transferFrom(capital);
        ca2.transferTo(capital);
        capitalAccountRepository.save(ca1);
        capitalAccountRepository.save(ca2);
        if (rp2.getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new NoRollbackException();
        }
        rp2.transferFrom(red);
        rp1.transferTo(red);
        redPacketAccountRepository.save(rp1);
        redPacketAccountRepository.save(rp2);

    }
}
