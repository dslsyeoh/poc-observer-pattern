package com.dsl.poc.controllers;

import com.dsl.poc.AttackChanged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class OnePunchManController
{
    @Autowired
    private GlobalAttackController globalAttackController;

    public void register(String... attacks)
    {
        globalAttackController.addPropertyChangeListener();
        Stream.of(attacks).forEach(globalAttackController::registerAttack);
        globalAttackController.removePropertyChangeListener();
    }

    public void test(String propertyName, String attack, String power)
    {
        AttackChanged attackChanged = get(propertyName);
        if (Objects.nonNull(attackChanged)) attackChanged.consume(attack, power);
    }

    private AttackChanged get(String propertyName)
    {
        return globalAttackController.get(propertyName);
    }
}
