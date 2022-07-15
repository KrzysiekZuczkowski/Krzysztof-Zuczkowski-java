package com.kodilla.patterns.combinator;

import com.kodilla.patterns.factory.tasks.Task;

import java.util.function.Function;

import static com.kodilla.patterns.combinator.CustomerReg.ValidationResult.*;

public interface CustomerReg extends Function<Task, CustomerReg.ValidationResult> {

//    static CustomerReg isTaskId() {
//        return task -> task.getId() > 0 ?
//                SUCCESS : IS_NOT_AN_ADULT;
//    }

    default CustomerReg and(CustomerReg other) {
        return task -> {
            ValidationResult result  = this.apply(task);
            return result.equals(SUCCESS) ? other.apply(task) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        IS_NOT_AN_ADULT
    }

}
