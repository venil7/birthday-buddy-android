package uk.co.darkruby.bbuddy.birthdaybuddy;

public class CatDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {


    public CatDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getCatYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        int catYears = ((fullYears >= 25)
                ? ((fullYears - 25) / 4 + 2)
                : (fullYears > 15 ? (fullYears - 15) / 10 + 1 : fullYears / 15));

        return catYears;
    }
}
