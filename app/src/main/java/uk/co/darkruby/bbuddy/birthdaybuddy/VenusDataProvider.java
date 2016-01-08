package uk.co.darkruby.bbuddy.birthdaybuddy;

public class VenusDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {

    private final int YEAR_LENGTH = 225;
    private final int DAY_LENGTH = 243;

    public VenusDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getVenetianYears() {
        return this.getDaysTillNow() / YEAR_LENGTH;
    }

    public int getVenetianDays() {
        return this.getDaysTillNow() / DAY_LENGTH;
    }
}