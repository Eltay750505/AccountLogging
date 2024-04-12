package org.gasimov.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private Long id;
    private BigDecimal money;

    public Account(Long id, BigDecimal money) {
        this.id = id;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(money, account.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money);
    }
}
