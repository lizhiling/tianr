package com.aws.codestar.projecttemplates.dto;

public interface Dto<T> {
    Dto <T>fromEntity(T entity);
}
