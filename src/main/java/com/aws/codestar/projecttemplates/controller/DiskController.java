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

import com.aws.codestar.projecttemplates.dto.DiskDto;
import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.repositories.DiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;


@RestController
@EnableWebMvc
public class DiskController {
    @Autowired
    DiskRepository diskRepository;

    @RequestMapping(path = "/disk", method = RequestMethod.POST)
    public ResponseEntity<Disk> createDisk(@RequestBody Disk newDisk) {
        Disk dbDisk = diskRepository.saveAndFlush(newDisk);
        return new ResponseEntity<Disk>(dbDisk, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/disk", method = RequestMethod.GET)
    public ResponseEntity<List<Disk>> listDisks() {
        List<Disk> diskList = diskRepository.findAll();

        return new ResponseEntity<>(diskList, HttpStatus.OK);
    }

    @RequestMapping(path = "/disk/{diskId}", method = RequestMethod.GET)
    public ResponseEntity<Disk> listDisk(@PathVariable int diskId) {
        return new ResponseEntity<>(diskRepository.findOne(diskId), HttpStatus.OK);
    }

}
