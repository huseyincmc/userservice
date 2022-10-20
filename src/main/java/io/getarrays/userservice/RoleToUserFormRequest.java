package io.getarrays.userservice;

import lombok.Data;

@Data
public class RoleToUserFormRequest {
    private String username;
    private String roleName;
}
