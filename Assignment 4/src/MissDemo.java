//----------------------------------------------------------------
// Assignment 4
// Written by: Mark Benedict Agluba, 40294956
// For COMP 248 Section S - Fall 2024
//----------------------------------------------------------------

/*
The program is a simulation the registry of any department/ficility of 6 universities which utlizes for their intercampus
shipment stamps and yearly prepaid subscription.
*/

import java.util.Scanner;

public class MissDemo {
    private static Registry[] registries = new Registry[5];

    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // initialize registries
        initializeRegistries();

        // welcoming message
        System.out.println("Welcome to Montreal InterCampuses Shipping Shipping Service(MISS) Application!\n");

        // main menu
        boolean isValid = false;
        while (!isValid) {
            try {
                displayMenu();
                int choice = input.nextInt();
                if (choice < 0 || choice > 9) {
                    System.out.println("Sorry that is not a valid choice. Try again.\n");
                    isValid = false;
                } else {
                    isValid = handleMenuChoice(input, choice);
                }

            } catch (Exception e) {
                input.next();
                System.out.println(
                        "You thought you did something with that huh? Trying to crash the porgram. Try again.\n");
                isValid = false;
            }
        }

    }

    // Initialize the registries as specified
    private static void initializeRegistries() {
        Label label1 = new Label("Type A", 101, 15, 6);
        Label label2 = new Label("Type B", 102, 10, 7);
        Label label3 = new Label("Type C", 103, 5, 8);

        // Registry 1 and 2: Same stamps distribution and labels
        Stamps stamps1 = new Stamps(2, 3, 1, 4, 0);
        registries[0] = new Registry(stamps1, new Label[] { label1, label2 });

        Stamps stamps2 = new Stamps(2, 3, 1, 4, 0);
        registries[1] = new Registry(stamps2, new Label[] { label1, label2 });

        // Registry 3: Same total $ amount as Registry 1, different stamp breakdown, 3
        // labels
        Stamps stamps3 = new Stamps(4, 0, 3, 0, 1);
        registries[2] = new Registry(stamps3, new Label[] { label1, label2, label3 });

        // Registry 4 and 5: Same stamps, no labels
        Stamps stamps4 = new Stamps(1, 2, 0, 3, 1);
        registries[3] = new Registry(stamps4, null);

        Stamps stamps5 = new Stamps(1, 2, 0, 3, 1);
        registries[4] = new Registry(stamps5, null);
    }

    // display the menu
    private static void displayMenu() {
        System.out.println("|   What would you like to do?");
        System.out.println("|   1 >> See the content of all Registries");
        System.out.println("|   2 >> See the content of one Registry");
        System.out.println("|   3 >> List Registries with the same $ amount of shipment stamps");
        System.out.println("|   4 >> List Registries with the same number of shipment Stamps types");
        System.out.println(
                "|   5 >> List Registries with the same amount $ amount of Stamps and same number of prepaid Labels");
        System.out.println("|   6 >> Add a prepaid label to an existing Registry");
        System.out.println("|   7 >> Remove an existing prepaid label from a Registry");
        System.out.println("|   8 >> Update the expiry date of an existing prepaid label");
        System.out.println("|   9 >> Add Stamps to a Registry");
        System.out.println("|   0 >> Exit\n\n");
        System.out.print("Please enter your choice and press <Enter>: ");
    }

    // handle menu choice
    private static boolean handleMenuChoice(Scanner input, int choice) {
        if (choice == 1) {
            displayAllRegistries();
            return false;
        } else if (choice == 2) {
            displayOneRegistry(input);
            return false;
        } else if (choice == 3) {
            displayRegistriesWithSameAmount();
            return false;
        } else if (choice == 4) {
            displayRegistriesWithSameNumberOfStamps();
            return false;
        } else if (choice == 5) {
            displayRegistriesWithSameAmountAndNumberOfLabels();
            return false;
        } else if (choice == 6) {
            addPrepaidLabel(input);
            return false;
        } else if (choice == 7) {
            removePrepaidLabel(input);
            return false;
        } else if (choice == 8) {
            updateExpiryDate(input);
            return false;
        } else if (choice == 9) {
            addStamps(input);
            return false;
        } else if (choice == 0) {
            System.out.println("Thank you for using Montreal International Shipping Services (MISS) Application!");
            return true;
        } else {
            return false;
        }
    }

    // display all registries
    private static void displayAllRegistries() {
        System.out.println("Content of each Registry: \n" + "-----------------------");
        for (int i = 0; i < registries.length; i++) {
            System.out.println("Registry #" + (i + 1) + ":");
            System.out.println(registries[i] + "\n");
        }
    }

    private static void displayOneRegistry(Scanner input) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Which Registry you want to see the content of? (Enter number 1 to 5): ");
                int registryIndex = input.nextInt();
                if (registryIndex < 0 || registryIndex > 5) {
                    System.out.print("Sorry but there is no Registry number " + registryIndex + ". Nice try though.\n"
                            + "--> Try again: ");
                    isValid = false;
                } else {
                    System.out.println("Registry #" + registryIndex + ":");
                    System.out.println(registries[registryIndex - 1] + "\n");
                    isValid = true;
                }
            } catch (Exception e) {
                input.next();
                System.out.println("BRUH! STOP CRASHING THE PROGRAM!\nCHOOSE BETWEEN THE NUMBERS!\n");
                isValid = false;
            }
        }
    }

    private static void displayRegistriesWithSameAmount() {
        System.out.println("List of Registries with the same total $ Stamps: \n");
        for (int i = 0; i < registries.length - 1; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].compareValueStamps(registries[j])) {
                    System.out.println("\t\tRegistries " + (i + 1) + " and " + (j + 1) + " both have $" +
                            registries[i].shipmentStamps() + " of total stamps.\n");
                }
            }
        }
    }

    private static void displayRegistriesWithSameNumberOfStamps() {
        System.out.println("List  of Registries with the same Stamps categories: \n");
        for (int i = 0; i < registries.length - 1; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].equals(registries[j])) {
                    System.out.println("\t\tRegistries " + (i + 1) + " and " + (j + 1) + " both have " +
                            registries[i].stampsBreakdown() + "\n");

                }
            }
        }
    }

    private static void displayRegistriesWithSameAmountAndNumberOfLabels() {
        System.out.println("List of Registries with the same $ amount of Stamps and same number of Labels: \n");
        for (int i = 0; i < registries.length - 1; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].compareValueStamps(registries[j]) &&
                        registries[i].numberOfLabels() == registries[j].numberOfLabels()) {
                    System.out.println("\t\tRegistries " + (i + 1) + " and " + (j + 1) + "\n");
                }
            }
        }
    }

    private static void addPrepaidLabel(Scanner input) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Which Registry do you want to add a Label to? (Enter number 1 to 5): ");
                int registryIndex = input.nextInt();
                if (registryIndex < 0 || registryIndex > 5) {
                    System.out.print("Sorry but there is no Registry number " + registryIndex + ". Nice try though.\n"
                            + "--> Try again: ");
                    isValid = false;
                } else {
                    System.out.print("Please enter the following information so that we may complete the Label -\n"
                            + "-->\tType of Label (Confidential, Small, Oversize, Express, Standard, Fragile): ");
                    input.nextLine();
                    String labelType = input.nextLine();
                    System.out.print("-->\tId of the prepaid label possessor: ");
                    int prepaidLabelId = input.nextInt();
                    input.nextLine();
                    System.out.print("-->\tExpiry day number and month (seperate by a space): ");
                    String expiryDate = input.nextLine();
                    String[] date = expiryDate.split(" ");
                    int newLabelLength = registries[registryIndex - 1].addLabel(new Label(labelType, prepaidLabelId,
                            Integer.parseInt(date[0]), Integer.parseInt(date[1])));
                    System.out.println(
                            " The total labels for registry " + registryIndex + " is now: " + newLabelLength + "\n");
                    isValid = true;
                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println("BRO IS PERSISTENT ON CRASHING THE PROGRAM!\nCHOOSE BETWEEN THE NUMBERS!\n");
                isValid = false;
            }
        }
    }

    private static void removePrepaidLabel(Scanner input) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Which Registry do you want to remove a Label from? (Enter number 1 to 5): ");
                int registryIndex = input.nextInt();
                if (registryIndex < 0 || registryIndex > 5) {
                    System.out.print("Sorry but there is no Registry number " + registryIndex + ". Nice try though.\n"
                            + "--> Try again: ");
                    isValid = false;
                } else if (registries[registryIndex - 1].numberOfLabels() == 0) {
                    System.out.println("There are no labels in Registry " + registryIndex);
                    isValid = false;
                } else {
                    input.nextLine();
                    System.out.println("There are " + registries[registryIndex - 1].numberOfLabels() +
                            " in Registry " + registryIndex + ".\n");
                    System.out.print("Which label are you removing)? ");
                    int labelIndex = input.nextInt();
                    if (!registries[registryIndex - 1].removeLabel(labelIndex - 1)) {
                        System.out.println(
                                "There is no Label " + labelIndex + " in Registry " + registryIndex + ". Try again.\n");
                        isValid = false;
                    } else {
                        System.out.println("The total labels for registry " + registryIndex + " is now: " +
                                registries[registryIndex - 1].numberOfLabels() + "\n");
                        isValid = true;

                    }

                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println("I AM LOSING PATIENCE! STOP CRASHING THE PROGRAM!\nCHOOSE BETWEEN THE NUMBERS!\n");
                isValid = false;
            }
        }
    }

    private static void updateExpiryDate(Scanner input) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Which Registry do you want to update a Label form? (Enter number 1 to 5): ");
                int registryIndex = input.nextInt();
                if (registryIndex < 0 || registryIndex > 5) {
                    System.out.println("Sorry but there is no Registry number " + registryIndex + ". Nice try though.\n"
                            + "--> Try again:");
                    isValid = false;
                } else if (registries[registryIndex - 1].numberOfLabels() == 0) {
                    System.out.println("There are no labels in Registry " + registryIndex);
                    isValid = false;
                } else {
                    input.nextLine();
                    System.out.println("There are " + registries[registryIndex - 1].numberOfLabels() + " in Registry " +
                            registryIndex + ".\n");
                    System.out.print("Which Label do you want to update? ");
                    int labelIndex = input.nextInt();
                    if (labelIndex > registries[registryIndex - 1].numberOfLabels() || labelIndex < 1) {
                        System.out.println(
                                "There is no Label " + labelIndex + " in Registry " + registryIndex + ". Try again.\n");
                        isValid = false;
                    } else {
                        input.nextLine();
                        System.out.print("-->\tEnter new expiry date day number and month (seperate by a space): ");
                        String expiryDate = input.nextLine();
                        String[] date = expiryDate.split(" ");
                        registries[registryIndex - 1].updateExpiryDate(labelIndex - 1, Integer.parseInt(date[0]),
                                Integer.parseInt(date[1]));
                        System.out.println("The Label's expiry date has been updated.\n");
                        isValid = true;
                    }
                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println(
                        "STOP CRASHING THE PROGRAM! I AM TIRED OF TYPING THESE VALIDATIONS!\nCHOOSE BETWEEN THE NUMBERS!\n");
                isValid = false;
            }
        }
    }

    private static void addStamps(Scanner input) {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Which Registry do you want to add Stamps to? (Enter number 1 to 5): ");
                int registryIndex = input.nextInt();
                if (registryIndex < 0 || registryIndex > 5) {
                    System.out.println("Sorry but there is no Registry number " + registryIndex + ". Nice try though.\n"
                            + "--> Try again:");
                    isValid = false;
                } else {
                    input.nextLine();
                    System.out.print("How many category_A($2), category_B($5), " +
                            "category_C($10), category_D($15) and category_E($20) parcel stamps do you want to add?\n" +
                            "Enter 5 numbers seperated by a space: ");
                    String numberOfStamps = input.nextLine();
                    String[] stamps = numberOfStamps.split(" ");
                    registries[registryIndex - 1].addShipmentStamps(Integer.parseInt(stamps[0]),
                            Integer.parseInt(stamps[1]),
                            Integer.parseInt(stamps[2]), Integer.parseInt(stamps[3]), Integer.parseInt(stamps[4]));
                    System.out.println("You now have $" + registries[registryIndex - 1].shipmentStamps() + ".0");
                    isValid = true;
                }
            } catch (Exception e) {
                input.nextLine();
                System.out.println("THIS IS THE LAST OPTION AND YOU ARE STILL BREAKING THE PROGRAM?!" +
                        "GIVE IT UP ALREADY!\nCHOOSE BETWEEN THE NUMBERS!\n");
                isValid = false;
            }
        }
    }
}
