package services;

import DAO.RoleDao;
import models.Role;

import java.util.List;

public class RoleService {
    private RoleDao roleDao = new RoleDao();

    public RoleService(){}

    public Role findRole(int id){
        return roleDao.findById(id);
    }

    public void saveRole(Role role){
        roleDao.save(role);
    }

    public void updateRole(Role role){
        roleDao.update(role);
    }

    public void deleteRole(Role role){
        roleDao.delete(role);
    }

    public List<Role> findAllRoles(){
        return roleDao.getAll();
    }

}