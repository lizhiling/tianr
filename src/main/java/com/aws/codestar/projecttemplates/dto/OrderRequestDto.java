package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.Material;
import com.aws.codestar.projecttemplates.entities.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto implements Dto<OrderRequestDto> {
    private UUID id;

    private OrderRequest.OrderType ordertype;

    private Date lastUpdateTime;

    private Set<Integer> disks = new HashSet<>();

    private String note;

    @Override
    public Dto<OrderRequestDto> fromEntity(OrderRequestDto entity) {
        this.setId(entity.getId());
        this.setLastUpdateTime(entity.getLastUpdateTime());
        this.setOrdertype(entity.getOrdertype());
        this.setNote(entity.getNote());
        this.setDisks(entity.getDisks());
        return this;
    }
}
