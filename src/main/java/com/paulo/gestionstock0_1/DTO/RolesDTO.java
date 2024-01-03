package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDTO {
    private Integer id;

    private String roleNom;

    private UtilisateurDTO utilisateurDTO;

    private Integer idEntreprise;

    public static RolesDTO fromEntity(Roles roles){
        if (roles == null){
            return null;
        }
        return RolesDTO.builder()
                .id(roles.getId())
                .roleNom(roles.getRoleNom())
                .idEntreprise(roles.getIdEntreprise())
                .build();
    }

    public static Roles toEntity(RolesDTO rolesDTO){
        if (rolesDTO == null){
            return null;
        }
        Roles roles = new Roles();

        roles.setId(rolesDTO.getId());
        roles.setRoleNom(rolesDTO.getRoleNom());
        roles.setIdEntreprise(rolesDTO.getIdEntreprise());

        return roles;
    }
}
