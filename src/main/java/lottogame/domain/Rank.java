package lottogame.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final int MIN_MATCH_NUMBER = 0;
    private static final int MAX_MATCH_NUMBER = 6;

    private int numberOfMatch;
    private long prize;

    Rank(int numberOfMatch, int prize) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank valueOf(int numberOfMatch, boolean bonusBallMatch) {
        if (numberOfMatch < MIN_MATCH_NUMBER || numberOfMatch > MAX_MATCH_NUMBER) {
            throw new IllegalArgumentException("올바른 매칭 개수가 아닙니다.");
        }
        if (numberOfMatch == SECOND.numberOfMatch && bonusBallMatch) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(numberOfMatch))
                .findAny()
                .orElse(MISS);
    }

    private boolean isMatch(int numberOfMatch) {
        return this.numberOfMatch == numberOfMatch;
    }

    public long sumPrizeOf(Integer numberOfMatch) {
        return prize * numberOfMatch;
    }
}