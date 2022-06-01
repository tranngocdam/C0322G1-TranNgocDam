package service.impl;

import model.User;
import repository.IUserDAO;
import repository.impl.UserDAO;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDAO iUserDAO=new UserDAO();

    @Override
    public void insertUser(User user) throws SQLException {
        this.iUserDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
       return this.iUserDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.iUserDAO.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return this.iUserDAO.findByCountry(country);
    }

    @Override
    public List<User> usersSort(String sortName) {
        return this.iUserDAO.usersSort(sortName);
    }
}
