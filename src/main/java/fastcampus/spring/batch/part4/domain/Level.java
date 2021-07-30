package fastcampus.spring.batch.part4.domain;

public enum Level {
    VIP(500_000, null),
    GOLD(500_000, VIP),
    SILVER(300_000, GOLD),
    NORMAL(200_000, SILVER);

    private final int nextAmount;
    private final Level nextLevel;

    Level(int nextAmount, Level nextLevel) {
        this.nextAmount = nextAmount;
        this.nextLevel = nextLevel;
    }
}
