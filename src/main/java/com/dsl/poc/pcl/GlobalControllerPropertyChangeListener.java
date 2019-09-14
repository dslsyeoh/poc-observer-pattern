package com.dsl.poc.pcl;

import com.dsl.poc.Attacker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class GlobalControllerPropertyChangeListener implements PropertyChangeListener
{
    private Map<String, Attacker> attackChangedMap = new HashMap<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        setAttackChangedMap(evt.getPropertyName(), (Attacker) evt.getNewValue());
    }

    private void setAttackChangedMap(String key, Attacker attacker)
    {
        attackChangedMap.put(key, attacker);
    }

    Map<String, Attacker> getAttackMap()
    {
        return attackChangedMap;
    }
}
