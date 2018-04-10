package com.aws.codestar.projecttemplates.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiskDto {
    private int id;

    private String name;
    private String description;
    private String img;

    private Set<MaterialDto> materials = new HashSet<>();
}
