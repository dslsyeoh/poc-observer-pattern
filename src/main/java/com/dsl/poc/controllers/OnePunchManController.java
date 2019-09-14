package com.dsl.poc.controllers;

import com.dsl.poc.Attacker;
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
        Attacker attacker = get(propertyName);
        if (Objects.nonNull(attacker)) attacker.register("OPM", attack, power);
    }

    private Attacker get(String propertyName)
    {
        return globalAttackController.get(propertyName);
    }
}
