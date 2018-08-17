package com.belili.dao;

import com.belili.pojo.Customer;
import java.util.List;

public interface CustomerDAO {

    public Customer selectById(Integer id);
    
    public boolean selectByCode(Customer customer);

    public List<Customer> selectAll();

    public boolean create(Customer customer);
    
    public boolean update(Customer customer);    
}
