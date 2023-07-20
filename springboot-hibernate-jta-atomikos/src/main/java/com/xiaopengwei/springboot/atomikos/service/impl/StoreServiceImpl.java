package com.xiaopengwei.springboot.atomikos.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

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
 * @author github.com/xpwi
 * @since 2019-04-04
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CapitalAccountRepository capitalAccountRepository;

    @Autowired
    private RedPacketAccountRepository redPacketAccountRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transfer() {
        Optional<CapitalAccount> ca1 = capitalAccountRepository.findById(1L);
        Optional<CapitalAccount> ca2 = capitalAccountRepository.findById(2L);
        Optional<RedPacketAccount> rp1 = redPacketAccountRepository.findById(1L);
        Optional<RedPacketAccount> rp2 = redPacketAccountRepository.findById(2L);
        BigDecimal capital = BigDecimal.TEN;
        ca1.ifPresent(cap -> {
            cap.transferFrom(capital);
            capitalAccountRepository.save(cap);
        });
        ca2.ifPresent(cap -> {
            cap.transferTo(capital);
            capitalAccountRepository.save(cap);
        });

        BigDecimal red = BigDecimal.TEN;
        rp2.ifPresent(rp -> {
            rp.transferFrom(red);
            redPacketAccountRepository.save(rp);
        });
        rp1.ifPresent(rp -> {
            rp.transferTo(red);
            redPacketAccountRepository.save(rp);
        });
    }

    @Override
    @Transactional(rollbackFor = StoreException.class)
    public void transferWithStoreException() throws StoreException {
        Optional<CapitalAccount> ca1 = capitalAccountRepository.findById(1L);
        Optional<CapitalAccount> ca2 = capitalAccountRepository.findById(2L);
        Optional<RedPacketAccount> rp1 = redPacketAccountRepository.findById(1L);
        Optional<RedPacketAccount> rp2 = redPacketAccountRepository.findById(2L);

        BigDecimal capital = BigDecimal.TEN;
        ca1.ifPresent(cap -> {
            cap.transferFrom(capital);
            capitalAccountRepository.save(cap);
        });
        ca2.ifPresent(cap -> {
            cap.transferTo(capital);
            capitalAccountRepository.save(cap);
        });

        BigDecimal red = BigDecimal.TEN;
        if (rp2.isPresent()) {
            if (rp2.get().getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new StoreException();
            }
            rp2.get().transferFrom(red);
            redPacketAccountRepository.save(rp2.get());
        }

        rp1.ifPresent(rp -> {
            rp.transferTo(red);
            redPacketAccountRepository.save(rp);
        });
    }

    @Override
    @Transactional(noRollbackFor = NoRollbackException.class, rollbackFor = StoreException.class)
    public void transferWithNoRollbackException() throws NoRollbackException {
        Optional<CapitalAccount> ca1 = capitalAccountRepository.findById(1L);
        Optional<CapitalAccount> ca2 = capitalAccountRepository.findById(2L);
        Optional<RedPacketAccount> rp1 = redPacketAccountRepository.findById(1L);
        Optional<RedPacketAccount> rp2 = redPacketAccountRepository.findById(2L);

        BigDecimal capital = BigDecimal.TEN;
        ca1.ifPresent(cap -> {
            cap.transferFrom(capital);
            capitalAccountRepository.save(cap);
        });
        ca2.ifPresent(cap -> {
            cap.transferTo(capital);
            capitalAccountRepository.save(cap);
        });

        BigDecimal red = BigDecimal.TEN;
        if (rp2.isPresent()) {
            if (rp2.get().getBalanceAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new NoRollbackException();
            }
            rp2.get().transferFrom(red);
            redPacketAccountRepository.save(rp2.get());
        }

        rp1.ifPresent(rp -> {
            rp.transferTo(red);
            redPacketAccountRepository.save(rp);
        });

    }


}
