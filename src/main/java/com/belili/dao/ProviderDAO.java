package com.belili.dao;

import com.belili.pojo.Provider;
import java.util.List;

public interface ProviderDAO {

     public Provider selectById(Integer id);
    
    public boolean selectByCode(Provider provider);

    public List<Provider> selectAll();

    public boolean create(Provider provider);
    
    public boolean update(Provider provider); 
}
