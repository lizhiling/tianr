package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.entities.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiskDto implements Dto<Disk>{
    private int id;

    private String name;
    private String description;
    private String img;

    private Set<MaterialDto> materials = new HashSet<>();

    @Override
    public DiskDto fromEntity(Disk entity) {
        Set<MaterialDto> materialDtos = entity.getMaterials().stream()
                .map((m) -> new MaterialDto().fromEntity(m))
                .collect(Collectors.toSet());
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setDescription(entity.getDescription());
        this.setImg(entity.getImg());
        this.setMaterials(materialDtos);
        return this;
    }
}
