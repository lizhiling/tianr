package com.aws.codestar.projecttemplates.dto;

public interface Vo<T> {
    Vo<T> fromEntity(T entity);

    // todo: need to investigate more.
    static<T,S extends Vo> S buildVoFromEntity(Class<S> voClass, T entity){
        S vo = null;
        try {
            vo = (S)voClass.newInstance().fromEntity(entity);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
