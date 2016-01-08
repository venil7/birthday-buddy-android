package uk.co.darkruby.bbuddy.birthdaybuddy;

public class DogDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {


    public DogDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getDogYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        double dogYears = (fullYears >= 21)
            ? (fullYears - 21)/4 + 2
            : fullYears/10.5;

        return ((int) dogYears);
    }
}
