/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.poc.controllers;

import com.dsl.poc.Attacker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class NormalPersonController
{
    @Autowired
    private GlobalAttackController globalAttackController;

    public void register(String... attacks)
    {
        globalAttackController.addPropertyChangeListener();
        Stream.of(attacks).forEach(globalAttackController::registerAttack);
        globalAttackController.removePropertyChangeListener();
    }

    public void test(String propertyName, String attack, int attackRank)
    {
        Attacker attacker = get(propertyName);
        if (Objects.nonNull(attacker)) attacker.register("Normal guy", attack, attackRank);
    }

    private Attacker get(String propertyName)
    {
        return globalAttackController.get(propertyName);
    }
}
