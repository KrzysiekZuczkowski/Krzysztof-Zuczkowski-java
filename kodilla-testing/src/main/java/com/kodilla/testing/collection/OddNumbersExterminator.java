package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();

        if(list.size() == 0)
            return resultList;

        for(Integer integer : list)
            if(integer % 2 == 0)
                resultList.add(integer);

        return resultList;
    }
}
