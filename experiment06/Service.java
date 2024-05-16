package com.experiments.experiment06;

import java.util.List;

public class Service {
    public static Ship load(Ship ship, List<Container> containers) throws OverweightException{
        double totalweight = 0;
        for (Container c : containers){
            totalweight = totalweight + c.getWeight();
        }

        if (totalweight > ship.getTotalWeight()){
            throw new OverweightException(ship.getId(), totalweight - ship.getTotalWeight());
        }

        for (Container c : containers){
            ship.getContainers().add(c);
        }

        return ship;
    }
}
