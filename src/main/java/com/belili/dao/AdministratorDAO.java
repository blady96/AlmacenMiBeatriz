package com.belili.dao;

import com.belili.pojo.Administrator;

public interface AdministratorDAO {
    
    public Administrator selectById(Integer id);
    
    public boolean login(Administrator administrator);

    public boolean update(Administrator administrator);
    
}
