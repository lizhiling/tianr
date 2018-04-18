package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.entities.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto implements Dto<Material> {
    private int id;

    private String name;
    private String alias;

    @Override
    public MaterialDto fromEntity(Material entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setAlias(entity.getAlias());
        return this;
    }
}
