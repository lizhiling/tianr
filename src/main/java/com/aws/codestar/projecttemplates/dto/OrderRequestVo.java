package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestVo implements Vo<OrderRequest> {
    private UUID id;

    private OrderRequest.OrderType ordertype;

    private Date lastUpdateTime;

    private Set<Integer> disks = new HashSet<>();

    private String note;

    private List<ToBuyMaterialVo> toBuyMaterials;

    @Override
    public OrderRequestVo fromEntity(OrderRequest entity) {
        this.setId(entity.getId());
        this.setLastUpdateTime(entity.getLastUpdateTime());
        this.setOrdertype(entity.getOrdertype());
        this.setNote(entity.getNote());
        this.setDisks(entity.getDisks());


        this.setToBuyMaterials(entity.getMaterials().stream().map(
                material -> Vo.buildVoFromEntity(ToBuyMaterialVo.class, material))
                .collect(Collectors.toList()));

        return this;
    }
}
