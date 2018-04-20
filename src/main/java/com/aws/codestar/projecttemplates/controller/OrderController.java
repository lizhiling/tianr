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

import com.aws.codestar.projecttemplates.dto.OrderRequestVo;
import com.aws.codestar.projecttemplates.dto.ToBuyMaterialVo;
import com.aws.codestar.projecttemplates.dto.Vo;
import com.aws.codestar.projecttemplates.entities.*;
import com.aws.codestar.projecttemplates.repositories.*;
import com.aws.codestar.projecttemplates.services.OrderRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@EnableWebMvc
public class OrderController {
    @Autowired
    OrderRequestRepository orderRequestRepository;

    @Autowired
    OrderRequestService orderRequestService;

    @RequestMapping(path = "/orderRequest", method = RequestMethod.POST)
    public ResponseEntity<OrderRequestVo> createOrderRequest(@RequestBody OrderRequest newOrderRequest) {
        OrderRequest dbOrderRequest = orderRequestService.createOrderRequest(newOrderRequest);
        OrderRequestVo dbOrderRequestVo = Vo.buildVoFromEntity(OrderRequestVo.class, dbOrderRequest);

        return new ResponseEntity<>(dbOrderRequestVo, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/orderRequest", method = RequestMethod.GET)
    public ResponseEntity<List<OrderRequest>> listOrderRequests() {
        List<OrderRequest> orderRequestList = orderRequestRepository.findAll();

        return new ResponseEntity<>(orderRequestList, HttpStatus.OK);
    }

    // For now, only to update status of ToBuyMaterial
    @RequestMapping(path = "/orderRequest", method = RequestMethod.PUT)
    public ResponseEntity<OrderRequestVo> putOrderRequest(@RequestBody OrderRequestVo updateOrderRequest){
        OrderRequest dbOrderRequest = orderRequestService.updateOrderRequest(updateOrderRequest);
        OrderRequestVo dbOrderRequestVo = Vo.buildVoFromEntity(OrderRequestVo.class, dbOrderRequest);
        return new ResponseEntity<>(dbOrderRequestVo, HttpStatus.OK);
    }

    @RequestMapping(path = "/orderRequest/{orderRequestId}", method = RequestMethod.GET)
    public ResponseEntity<OrderRequest> listOrderRequest(@PathVariable UUID orderRequestId) {
        return new ResponseEntity<>(orderRequestRepository.findOne(orderRequestId), HttpStatus.OK);
    }

}
