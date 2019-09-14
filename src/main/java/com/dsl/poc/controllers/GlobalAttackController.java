package com.dsl.poc.controllers;

import com.dsl.poc.AttackChanged;
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

    private void identifyAttackLevel(String attack, String power)
    {
        switch (power)
        {
            case "weak":
                System.out.println(attack + " is a joke");
                break;
            case "average":
                System.out.println(attack + " can kill normal person");
                break;
            case "hard":
                System.out.println(attack + " can kill any person");
                break;
            case "extreme hard":
                System.out.println(attack + " can destroy town");
                break;
            case "disaster":
                System.out.println(attack + " can destroy humanity");
                break;
            default:
                System.out.println(power + " cannot be identified");
                break;
        }
    }

    AttackChanged get(String propertyName)
    {
        return globalControllerListener.fireProperty(propertyName);
    }

    void removePropertyChangeListener()
    {
        globalControllerListener.removePropertyChangeListener();
    }
}
