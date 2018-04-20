package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.Disk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiskVo implements Vo<Disk> {
    private int id;

    private String name;
    private String description;
    private String img;

    private Set<MaterialVo> materials = new HashSet<>();

    @Override
    public DiskVo fromEntity(Disk entity) {
        Set<MaterialVo> materialDtos = entity.getMaterials().stream()
                .map((m) -> new MaterialVo().fromEntity(m))
                .collect(Collectors.toSet());
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setDescription(entity.getDescription());
        this.setImg(entity.getImg());
        this.setMaterials(materialDtos);
        return this;
    }
}
