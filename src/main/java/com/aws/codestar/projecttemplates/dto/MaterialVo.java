package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialVo implements Vo<Material> {
    private int id;

    private String name;
    private String alias;

    @Override
    public MaterialVo fromEntity(Material entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setAlias(entity.getAlias());
        return this;
    }
}
