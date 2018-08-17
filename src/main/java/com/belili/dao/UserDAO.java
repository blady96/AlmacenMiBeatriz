package com.belili.dao;

import com.belili.pojo.User;
import java.util.List;

public interface UserDAO {

    public User selectById(Integer id);
    
    public boolean selectByCode(User user);

    public List<User> selectAll();

    public boolean login(User user);

    public boolean create(User user);
    
    public boolean createTest(User user);

    public boolean update(User user);

}
