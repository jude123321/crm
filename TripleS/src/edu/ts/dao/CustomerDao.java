package edu.ts.dao;

import edu.ts.entity.Customer;

import java.util.List;

/**
 * Created by jose on 2017/3/2.
 */
public interface CustomerDao {
    /**
     * 添加会员
     *
     * @param customer 会员
     * @return 会员id
     */
    public int addCustomer(Customer customer);

    /**
     * 通过会员编号删除会员
     *
     * @param customer
     * @return 成功true 失败false
     */
    public boolean deleteCustomer(Customer customer);

    /**
     * 修改会员
     *
     * @param customer
     * @return
     */
    public Customer modifyCustomer(Customer customer);


    /**
     * 获取所有会员
     *
     * @return 会员的集合
     */
    public List<Customer> getCustomerList();

    /**
     * 通过用户手机号查询用户
     *
     * @param cTel 用户手机号
     * @return customer
     */
    public Customer getCustomerByTel(String cTel);

    /**
     *通过id获取会员
     *
     * @param id
     * @return customer
     */
    public Customer getCustomerById(int id);
}
