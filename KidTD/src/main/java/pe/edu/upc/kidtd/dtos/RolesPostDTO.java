package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.User;

public class RolesPostDTO {
    private int roleId;
    private String role_name;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


}
