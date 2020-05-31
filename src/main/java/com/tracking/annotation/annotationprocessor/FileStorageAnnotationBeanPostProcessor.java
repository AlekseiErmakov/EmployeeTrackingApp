package com.tracking.annotation.annotationprocessor;

import com.tracking.annotation.custom.FileStorage;
import com.tracking.annotation.custom.LocationContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Service
public class FileStorageAnnotationBeanPostProcessor implements BeanPostProcessor {

    Map<Class<?>,String> fileStorage = new HashMap<>();
    Map<String,Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(FileStorage.class)){
            FileStorage annotation = beanClass.getAnnotation(FileStorage.class);
            fileStorage.put(annotation.key(),annotation.location());
        }else if (isFieldAnnotationPresent(beanClass.getDeclaredFields())){
            beans.put(beanName,bean);
        }

        return bean;
    }

    private boolean isFieldAnnotationPresent(Field[] fields){
        return Arrays.stream(fields).anyMatch(field -> field.isAnnotationPresent(LocationContainer.class));
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object old = beans.get(beanName);
        if (old == null){
            return bean;
        }
        Class<?> aClass = old.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            if (field.getAnnotation(LocationContainer.class)!=null){
                Class<?> beanClass = bean.getClass();
                Field field1 = ReflectionUtils.findField(beanClass, field.getName());
                field1.setAccessible(true);
                ReflectionUtils.setField(field1,bean,fileStorage);
            }
        }
        return bean;
    }



}
