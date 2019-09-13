package com.dsl.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OneAttackController
{
    @Autowired
    private GlobalAttackController globalAttackController;

    public void fire(String propertyName)
    {
        globalAttackController.fire(propertyName);
    }
}
