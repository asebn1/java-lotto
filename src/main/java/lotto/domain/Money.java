package lotto.domain;

import lotto.exception.InvalidException;

public class Money {

    private final int money;

    public Money(final String money) {
        checkInputMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void checkInputMoney(final String money) {
        checkValidateInt(money);
        checkDivideMoney(Integer.parseInt(money));
    }

    private void checkValidateInt(final String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(InvalidException.ERROR_WRONG_INPUT_MONEY);
        }
    }

    private void checkDivideMoney(final int money) {
        if (!(money >= Constant.BASIC_LOTTO_MONEY && money % Constant.BASIC_LOTTO_MONEY == 0)) {
            throw new IllegalArgumentException(InvalidException.ERROR_WRONG_INPUT_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }
}
