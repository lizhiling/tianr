package com.aws.codestar.projecttemplates.services;

import com.aws.codestar.projecttemplates.dto.OrderRequestVo;
import com.aws.codestar.projecttemplates.dto.ToBuyMaterialVo;
import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.entities.Material;
import com.aws.codestar.projecttemplates.entities.OrderRequest;
import com.aws.codestar.projecttemplates.entities.ToBuyMaterial;
import com.aws.codestar.projecttemplates.repositories.DiskMaterialRepository;
import com.aws.codestar.projecttemplates.repositories.DiskRepository;
import com.aws.codestar.projecttemplates.repositories.OrderRequestRepository;
import com.aws.codestar.projecttemplates.repositories.ToBuyMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderRequestService {

    @Autowired
    OrderRequestRepository orderRequestRepository;
    @Autowired
    DiskMaterialRepository diskMaterialRepository;
    @Autowired
    DiskRepository diskRepository;
    @Autowired
    ToBuyMaterialRepository toBuyMaterialRepository;

    public OrderRequest createOrderRequest(OrderRequest orderRequest) {
        // save orderRequest
        OrderRequest dbOrderRequest = orderRequestRepository.save(orderRequest);

        // generate dbOrderRequest and save
        Set<Disk> disks = diskRepository.getDisksByIdIn(dbOrderRequest.getDisks());

        final List<Material> materialsByDisks = diskMaterialRepository.getMaterialsByDisksIn(disks);
        HashMap<Material, Integer> toBuyMaterialsMap = new HashMap<>();
        for (Material material: materialsByDisks){
            toBuyMaterialsMap.computeIfPresent(material, (old, oldAmount)-> oldAmount+1);
            toBuyMaterialsMap.putIfAbsent(material, 1);
        }
        List<ToBuyMaterial> dbOrderRequestMaterials = new LinkedList<>();
        for (Map.Entry<Material, Integer> entry: toBuyMaterialsMap.entrySet()){
            ToBuyMaterial toBuyMaterial = new ToBuyMaterial();
            toBuyMaterial.setOrderRequest(dbOrderRequest);
            toBuyMaterial.setMaterial(entry.getKey());
            toBuyMaterial.setAmount(entry.getValue());
            dbOrderRequestMaterials.add(toBuyMaterial);
        }

        dbOrderRequest.setMaterials(dbOrderRequestMaterials);
        toBuyMaterialRepository.save(dbOrderRequestMaterials);

        return saveToDB(dbOrderRequest);
    }

    public OrderRequest updateOrderRequest(OrderRequestVo orderRequestVo) {
        final List<ToBuyMaterialVo> toBuyMaterials = orderRequestVo.getToBuyMaterials();
        toBuyMaterials.forEach((m) -> {
            ToBuyMaterial toBuyMaterial = toBuyMaterialRepository.findOne(m.getId());
            if (m.isBought() != toBuyMaterial.isBought()){
                toBuyMaterial.setBought(m.isBought());
                toBuyMaterialRepository.saveAndFlush(toBuyMaterial);
            }
        });
        return orderRequestRepository.findOne(orderRequestVo.getId());
    }

    private OrderRequest saveToDB(OrderRequest o){
        o.setLastUpdateTime(new Date());
        return orderRequestRepository.saveAndFlush(o);
    }
}
