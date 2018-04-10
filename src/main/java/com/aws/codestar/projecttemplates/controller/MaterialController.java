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

import com.aws.codestar.projecttemplates.entities.Material;
import com.aws.codestar.projecttemplates.repositories.DiskMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;


@RestController
@EnableWebMvc
public class MaterialController {
    @Autowired
    DiskMaterialRepository materialRepository;

    @RequestMapping(path = "/material", method = RequestMethod.POST)
    public ResponseEntity<Material> createMaterial(@RequestBody Material newMaterial) {
        Material dbMaterial = materialRepository.saveAndFlush(newMaterial);
        return new ResponseEntity<Material>(dbMaterial, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/material", method = RequestMethod.GET)
    public ResponseEntity<List<Material>> listMaterials() {
        List<Material> materialList = materialRepository.findAll();

        return new ResponseEntity<List<Material>>(materialList, HttpStatus.OK);
    }

    @RequestMapping(path = "/material/{materialId}", method = RequestMethod.GET)
    public ResponseEntity<Material> listMaterial(@PathVariable int materialId) {
        return new ResponseEntity<Material>(materialRepository.findOne(materialId), HttpStatus.OK);
    }

}
