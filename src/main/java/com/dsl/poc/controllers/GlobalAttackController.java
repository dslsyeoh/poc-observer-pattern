package com.dsl.poc.controllers;

import com.dsl.poc.Attacker;
import com.dsl.poc.pcl.GlobalControllerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GlobalAttackController
{
    @Autowired
    private GlobalControllerListener globalControllerListener;

    void addPropertyChangeListener()
    {
        globalControllerListener.addPropertyChangeListener();
    }

    void registerAttack(String propertyName)
    {
        globalControllerListener.setFirePropertyChange(propertyName, this::identifyAttackLevel);
    }

    private void identifyAttackLevel(String name, String attack, String power)
    {
        switch (power)
        {
            case "weak":
                System.out.println(format(name, attack, "is a joke"));
                break;
            case "average":
                System.out.println(format(name, attack, "kill normal person"));
                break;
            case "hard":
                System.out.println(format(name, attack, "kill any person"));
                break;
            case "extreme hard":
                System.out.println(format(name, attack, "can destroy town"));
                break;
            case "disaster":
                System.out.println(format(name, attack, "can destroy any creature"));
                break;
            default:
                System.out.println(format(name, attack, "cannot be identified"));
                break;
        }
    }

    private String format(String name, String attack, String powerDescription)
    {
        return String.format("%s %s %s", name, attack, powerDescription);
    }

    Attacker get(String propertyName)
    {
        return globalControllerListener.fireProperty(propertyName);
    }

    void removePropertyChangeListener()
    {
        globalControllerListener.removePropertyChangeListener();
    }
}
