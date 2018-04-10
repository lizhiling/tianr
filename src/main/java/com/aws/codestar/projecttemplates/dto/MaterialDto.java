package com.aws.codestar.projecttemplates.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto {
    private int id;

    private String name;
    private String alias;
}
