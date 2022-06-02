package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {

    boolean createOrder(User user, LocalDateTime orderFrom, LocalDateTime orderTo);
}
