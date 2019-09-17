/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.poc.pcl;

import com.dsl.poc.Attacker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class GlobalAttackControllerPCL implements PropertyChangeListener
{
    private Map<String, Attacker> attackChangedMap = new HashMap<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        put(evt.getPropertyName(), (Attacker) evt.getNewValue());
    }

    private void put(String key, Attacker attacker)
    {
        attackChangedMap.put(key, attacker);
    }

    Map<String, Attacker> getAttackMap()
    {
        return attackChangedMap;
    }
}
