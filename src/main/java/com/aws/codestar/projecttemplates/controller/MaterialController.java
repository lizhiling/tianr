/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.dto.MaterialVo;
import com.aws.codestar.projecttemplates.dto.ToBuyMaterialVo;
import com.aws.codestar.projecttemplates.dto.Vo;
import com.aws.codestar.projecttemplates.entities.Material;
import com.aws.codestar.projecttemplates.entities.ToBuyMaterial;
import com.aws.codestar.projecttemplates.repositories.DiskMaterialRepository;
import com.aws.codestar.projecttemplates.repositories.ToBuyMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@EnableWebMvc
public class MaterialController {
    @Autowired
    DiskMaterialRepository materialRepository;
    @Autowired
    ToBuyMaterialRepository toBuyMaterialRepository;

    @RequestMapping(path = "/material", method = RequestMethod.POST)
    public ResponseEntity<Material> createMaterial(@RequestBody Material newMaterial) {
        Material dbMaterial = materialRepository.saveAndFlush(newMaterial);
        return new ResponseEntity<Material>(dbMaterial, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/material", method = RequestMethod.GET)
    public ResponseEntity<List<MaterialVo>> listMaterials() {
        List<Material> materialList = materialRepository.findAll();
        List<MaterialVo> materialDtos = materialList.stream().map(
                (m) -> Vo.buildVoFromEntity(MaterialVo.class, m))
                .collect(Collectors.toList());
        return new ResponseEntity<List<MaterialVo>>(materialDtos, HttpStatus.OK);
    }


    // For single ToBuyMaterial update
    @RequestMapping(path = "/material/to_buy", method = RequestMethod.PUT)
    public ResponseEntity putToBuyMaterial(@RequestBody ToBuyMaterialVo toBuyMaterialVo){
        ToBuyMaterial toBuyMaterial = toBuyMaterialRepository.findOne(toBuyMaterialVo.getId());
        toBuyMaterial.setBought(toBuyMaterialVo.isBought());
        toBuyMaterialRepository.saveAndFlush(toBuyMaterial);
        return new ResponseEntity<>(Vo.buildVoFromEntity(ToBuyMaterialVo.class, toBuyMaterial), HttpStatus.OK);
    }

    @RequestMapping(path = "/material/{materialId}", method = RequestMethod.GET)
    public ResponseEntity<Material> listMaterial(@PathVariable int materialId) {
        return new ResponseEntity<Material>(materialRepository.findOne(materialId), HttpStatus.OK);
    }

}
