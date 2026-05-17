public class Tea extends CaffeinatedBeverage {

    public static final int DEFAULT_BREW_TEMP = 90;
    private int brewTemp;

    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        if (!this.setBrewTemp(brewTemp)) {
            System.out.println("Invalid data given to constructor");
            System.exit(0);
        }
    }

    public Tea() {
        super();
        this.setBrewTemp(DEFAULT_BREW_TEMP);
    }

    public Tea(Tea other) {
        if (other != null) {
            this.setAll(other.getName(), other.getOunces(), other.getPrice(), other.brewTemp);
        } else {
            System.out.println("Invalid data given to copy constructor");
            System.exit(0);
        }
    }

    public boolean setBrewTemp(int brewTemp) {
        if (brewTemp >= 0) {
            this.brewTemp = brewTemp;
            return true;
        } else {
            return false;
        }
    }

    public boolean setAll(String name, int ounces, double price, int brewTemp) {
        return super.setAll(name, ounces, price) && this.setBrewTemp(brewTemp);
    }

    public int getBrewTemp() {
        return this.brewTemp;
    }

    @Override
    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2);

        return String.format("Tea: %s, brewed @ %dC", caffeineString, this.brewTemp);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other instanceof Tea) {
            return false;
        }
        Tea otherTea = (Tea) other;
        return super.equals(otherTea) && this.brewTemp == otherTea.brewTemp;
    }
}
