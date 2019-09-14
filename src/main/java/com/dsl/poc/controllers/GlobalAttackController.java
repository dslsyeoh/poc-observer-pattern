package com.dsl.poc.controllers;

import com.dsl.poc.pcl.GlobalControllerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
public class GlobalAttackController
{
    @Autowired
    private GlobalControllerListener globalControllerListener;

    public void addPropertyChangeListener()
    {
        globalControllerListener.addPropertyChangeListener();
    }

    public void registerAttack(String propertyName)
    {
        globalControllerListener.setFirePropertyChange(propertyName, this::handleAttack);
    }

    private void handleAttack(String attack, String power)
    {
        identifyAttackLevel(attack, power);
    }

    private void identifyAttackLevel(String attack, String power)
    {
        switch (power)
        {
            case "weak":
                System.out.println(attack + " is a joke");
                break;
            case "average":
                System.out.println(attack + " can kill normal persons");
            case "pro":
                System.out.println(attack + " can kill non-professional persons");
                break;
            case "disaster":
                System.out.println(attack + " can destroy humanity");
                break;
            default:
                System.out.println(power + "cannot be identified");
        }
    }

    BiConsumer<String, String> get(String propertyName)
    {
        return globalControllerListener.fireProperty(propertyName);
    }

    public void removePropertyChangeListener()
    {
        globalControllerListener.removePropertyChangeListener();
    }

    public void enableListener()
    {
        globalControllerListener.enablePropertyChangeListener();
    }

    public void disableListener()
    {
        globalControllerListener.disablePropertyChangeListener();
    }
}
