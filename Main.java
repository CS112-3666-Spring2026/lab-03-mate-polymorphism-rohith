import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{

		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces, brewTemp, count = 0;
		String name;
		double price;
		
		do
		{
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Exit");
			System.out.print(">>");
			choice = keyboard.nextInt();
			keyboard.nextLine();

			switch (choice) {
				case 1: // Tea
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a Tea, put into array
					inventory[count] = new Tea(name, ounces, price, brewTemp);

					System.out.println("Your tea order has been added: " + inventory[count]);
					count++;
					break;
				case 2: // YerbaMate
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a YerbaMate, put into array
					inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);

					System.out.println("Your YerbaMate order has been added: " + inventory[count]);
					count++;
					break;
				case 3: // Exit Case
					System.out.println("\nAll Drinks: ");
					Main.printDrinks(inventory, count);

					System.out.printf("\nAverage Price = $%.2f\n", Main.findAveragePrice(inventory, count));

					YerbaMate mostExpensive = Main.findHighestPricedYerbaMate(inventory, count);
					if (mostExpensive != null) {
						System.out.printf("\nHighest Priced Mate = %s%n", mostExpensive);
					} else {
						System.out.println("No Yerba Mate found in price of drinks.");
					}

					break;
				default:
					System.out.println("ERROR: not a valid choice. Please try again.\n");

			}

		} while (choice != 3);
		keyboard.close();
	}

	public static void printDrinks(CaffeinatedBeverage[] drinks, int numDrinks) {
		for (int i = 0; i < numDrinks; i++) {
			System.out.println("Drink #" + (i + 1) + " = " + drinks[i]);
		}
	}

	public static double findAveragePrice(CaffeinatedBeverage[] drinks, int numDrinks) {
		double totalPrice = 0;
		for (int i = 0; i < numDrinks; i++) {
			totalPrice += drinks[i].getPrice();
		}
		return totalPrice / numDrinks;
	}

	public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] drinks, int numDrinks) {
		YerbaMate mate = new YerbaMate(), highestPrice = null;

		for (int i = 0; i < numDrinks; i++) {
			if (drinks[i].getClass() == mate.getClass()) {
				if (highestPrice == null) {
					highestPrice = (YerbaMate) drinks[i];
				} else if (highestPrice.getPrice() < drinks[i].getPrice()) {
					highestPrice = (YerbaMate) drinks[i];
				}
			}
		}
		return highestPrice;
	}
}