package edu.ts.service;

import edu.ts.entity.Customer;

import java.util.List;

/**
 * Created by jose on 2017/3/2.
 */
public interface CustomerService {
    /**
     * 注册会员
     *
     * @param customer
     */
    public void register(Customer customer);

}
