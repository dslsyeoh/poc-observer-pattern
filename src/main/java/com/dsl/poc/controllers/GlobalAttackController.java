package com.dsl.poc.controllers;

import com.dsl.poc.pcl.GlobalControllerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalAttackController
{
    @Autowired
    private GlobalControllerListener globalControllerListener;

    public void addListeners()
    {
        globalControllerListener.addPropertyChangeListener();
        globalControllerListener.setFirePropertyChange("handleOnePunch", this::handleOnePunch);
        globalControllerListener.setFirePropertyChange("handleOneKick", this::handleOneKick);
        globalControllerListener.setFirePropertyChange("handleTwoPunches", this::handleTwoPunches);
        globalControllerListener.setFirePropertyChange("handleTwoKicks", this::handleTwoKicks);
        globalControllerListener.setFirePropertyChange("handleThreePunches", this::handleThreePunches);
        globalControllerListener.setFirePropertyChange("handleThreeKicks", this::handleThreeKicks);
    }

    private void handleOnePunch()
    {
        System.out.println("one punch for you");
    }

    private void handleOneKick()
    {
        System.out.println("one kick for you");
    }

    private void handleTwoPunches()
    {
        System.out.println("two punch for you");
    }

    private void handleTwoKicks()
    {
        System.out.println("two punch for you");
    }

    private void handleThreePunches()
    {
        System.out.println("three punches for you");
    }

    private void handleThreeKicks()
    {
        System.out.println("three kicks for you");
    }

    void fire(String propertyName)
    {
        globalControllerListener.fireProperty(propertyName);
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
