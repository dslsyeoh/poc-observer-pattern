package com.dsl.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.BiConsumer;

@Component
public class OneAttackController
{
    @Autowired
    private GlobalAttackController globalAttackController;

    public void register()
    {
        globalAttackController.addPropertyChangeListener();
        globalAttackController.registerAttack("OneAttackController_punch");
        globalAttackController.registerAttack("OneAttackController_kick");
        globalAttackController.removePropertyChangeListener();
    }

    public void test(String propertyName, String attack, String power)
    {
        BiConsumer<String, String> biConsumer = get(propertyName);
        if(Objects.nonNull(biConsumer)) biConsumer.accept(attack, power);
    }

    private BiConsumer<String, String> get(String propertyName)
    {
        return globalAttackController.get(propertyName);
    }
}
