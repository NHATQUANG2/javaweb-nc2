package quang.dev.data.dao;

import java.util.List;

import quang.dev.data.dao.model.User;

public interface UserDao {

    public boolean insert(User user);

    public boolean update(User user);

    public boolean delete(int userId);

    public User find(int userId);

    public User find(String email, String password);

    public List<User> findAll();
    
    public User login(String email, String password);
    
    public User register(String email, String password);
}
