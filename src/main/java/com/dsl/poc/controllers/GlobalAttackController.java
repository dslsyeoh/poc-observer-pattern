package com.dsl.poc.controllers;

import com.dsl.poc.Attacker;
import com.dsl.poc.pcl.GlobalAttackControllerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GlobalAttackController
{
    @Autowired
    private GlobalAttackControllerListener globalAttackControllerListener;

    void addPropertyChangeListener()
    {
        globalAttackControllerListener.addPropertyChangeListener();
    }

    void registerAttack(String propertyName)
    {
        globalAttackControllerListener.setFirePropertyChange(propertyName, this::identifyAttackLevel);
    }

    private void identifyAttackLevel(String name, String attack, int attackRank)
    {
        switch (attackRank)
        {
            case 0:
                System.out.println(format(name, attack, "is a joke"));
                break;
            case 1:
                System.out.println(format(name, attack, "can hurt normal person"));
                break;
            case 2:
                System.out.println(format(name, attack, "can kill normal person"));
                break;
            case 3:
                System.out.println(format(name, attack, "can kill any person"));
                break;
            case 4:
                System.out.println(format(name, attack, "can destroy town"));
                break;
            case 5:
                System.out.println(format(name, attack, "can destroy any creature"));
                break;
            default:
                System.out.println(format(name, attack, "power not registered."));
                break;
        }
    }

    private String format(String name, String attack, String powerDescription)
    {
        return String.format("%s %s %s", name, attack, powerDescription);
    }

    Attacker get(String propertyName)
    {
        return globalAttackControllerListener.fireProperty(propertyName);
    }

    void removePropertyChangeListener()
    {
        globalAttackControllerListener.removePropertyChangeListener();
    }
}
