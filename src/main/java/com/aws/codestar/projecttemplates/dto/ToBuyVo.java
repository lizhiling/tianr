package com.aws.codestar.projecttemplates.dto;

//import com.aws.codestar.projecttemplates.entities.ToBuy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ToBuyVo implements Vo<ToBuy> {
//    private UUID id;
//
//    private OrderRequestVo orderRequest;
//
//    private List<ToBuyMaterialVo> materialsToBuy;
//
//    @Override
//    public ToBuyVo fromEntity(ToBuy entity) {
//        this.setMaterialsToBuy(entity.getMaterials().stream().map(
//                material -> Vo.buildVoFromEntity(ToBuyMaterialVo.class, material))
//                .collect(Collectors.toList()));
//        this.setId(entity.getOrderRequest().getId());
//        this.setOrderRequest(Vo.buildVoFromEntity(OrderRequestVo.class, entity.getOrderRequest()));
//
//        return this;
//    }
//}
