package com.aws.codestar.projecttemplates.dto;

import com.aws.codestar.projecttemplates.entities.ToBuyMaterial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToBuyMaterialVo implements Vo<ToBuyMaterial> {
    private long id;
    private MaterialVo material;

    private boolean bought;
    private int amount;

    @Override
    public ToBuyMaterialVo fromEntity(ToBuyMaterial entity) {
        this.setId(entity.getId());
        this.setAmount(entity.getAmount());
        this.setBought(entity.isBought());
        this.setMaterial(Vo.buildVoFromEntity(MaterialVo.class, entity.getMaterial()));
        return this;
    }
}
