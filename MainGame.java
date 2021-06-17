package javagame;

/* 
 * Art Josh Arriate
 * 06/15/21
 * MonsterGame
 * 
 */

import java.util.*;

public class MainGame {

	public static int EnemyKilled = 0;
	
	public static void main(String[] args) {
		
		//new GameGUI();
		
		//Game Keeps running until player stops
		boolean running = true;
		
		Scanner sc = new Scanner(System.in);
		GameSettings gs = new GameSettings();
		
		System.out.println(" _______________________________________________________________");
		System.out.println("|                                                               |");
		System.out.println("|                  [ Welcome to Evolution ]                     |");
		System.out.println("|                                                               |");
		System.out.println("|             {You have infiltrated a Starship}                 |");
		System.out.println("|                                                               |");
		System.out.println("|                                                               |");
		System.out.println("|> You are a Monster                                            |");
		System.out.println("|> Eat enemies                                                  |");
		System.out.println("|> Evolve and overtake the ship!                                |");
		System.out.println("|                                                               |");
		System.out.println(" _______________________________________________________________\n");
		
		MAIN:
			while (running) {
				
				System.out.println("|___________________________________________________|\n");
				
				gs.RandomHealth();
				String enemy = gs.enemyUnits[gs.rdm.nextInt(gs.enemyUnits.length)]; //This Makes a enemy string that randomizes what enemy you fight
				
				System.out.println("| As you roam the Ship, you come across a [ " + enemy + " ] ! |\n");
				
				while (gs.EnemyHealth > 0) {
					
					System.out.println(" ______________________________________________");
					System.out.println("|                                              |");
					System.out.println("\t|<3| Your Health: { " + gs.MHealth + " }");
					System.out.println("\t|}:<| " + enemy + "'s Health: { " + gs.EnemyHealth + " }\n");
					System.out.println("\tWhat will you do?\n");
					System.out.println("\t[ 1. Attack ]");
					System.out.println("\t[ 2. Regen ]");
					System.out.println("\t[ 3. Flee ]");
					System.out.println("|                                              |");
					System.out.println(" ______________________________________________\n");
					
					int userinput = sc.nextInt();
				
					//User Choices
					if (userinput == 1) {
				
						int DmgDealt = gs.MRandomAttack();
						int DmgTaken = gs.RandomAttack();
						
						gs.MHealth -= DmgTaken;
						gs.EnemyHealth -= DmgDealt;
						
						System.out.println(" ________________________________________________________________________");
						System.out.println("|                                                                        |");
						System.out.println("\t[ ! ] - Your claws mutilate the " + enemy + " for { " + DmgDealt + " } damage.");
						System.out.println("\t[ </3 ] - " + enemy + "'s weapon impair you for { " + DmgTaken + " } damage.");
						System.out.println("|                                                                        |");
						System.out.println(" ________________________________________________________________________\n");
						
						if (gs.MHealth < 1) {
							System.out.println("\tYou are too weak to move on due to serious injuries!");
							break;
						}
						
					}
					else if (userinput == 2) {
						
						if (gs.MHealth == 150) {
							System.out.println("\t~! You have already regenerated enough Health!\n");
						}
						else if (gs.MRegenPoints > 0) {
							gs.MHealth += gs.MRegenAmount;
							gs.MRegenPoints--;
							System.out.println(" ________________________________________________________________________");
							System.out.println("|                                                                        |");
							System.out.println("  ~ Your Monstrous Body starts to reform, healing you for [ " + gs.MRegenAmount + " ] Health.");
							System.out.println("  ~ Your Total Health is [ " + gs.MHealth + " ]");
							System.out.println("  ~ Due to low amount of stamina, you can only regenerate " + gs.MRegenPoints + " Time(s).");
							System.out.println("|                                                                        |");
							System.out.println(" ________________________________________________________________________\n");
											 
						}
						else {
							System.out.println("\t ~ You can no longer regenerate.");
						}
						
					}
					else if (userinput == 3) {
						
						System.out.println("\t > You scatter away from the " + enemy + " < ");
						continue MAIN;
					}
					else {
						System.out.println("YOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + userinput);
						System.out.println("\t Revoked");
					}
				}
				
				//If User health is below 1, You lose the game
				if (gs.MHealth < 1) {
					
					System.out.println("\tYou escape and return back to space, with no energy left..");
					break;
				
				}
				
				EnemyKilled++;
				
				System.out.println(" _______________________________________________________________");
				System.out.println("|                                                               |");
				System.out.println(" -> The " + enemy + " was slaughtered!                          ");
				System.out.println(" -> " + "You currently have " + gs.MHealth + " Health left.     ");
				System.out.println(" -> You have killed " + EnemyKilled + " enemies.                ");
				System.out.println("|                                                               |");
				System.out.println(" _______________________________________________________________\n");
				
				//Makes a Regen drop chance rate of 65 percent where a random number is 
				//generated up to 100 and if that random number is higher than 65, the user gets a regen point
				if (gs.rdm.nextInt(100) > gs.MRegenRecover) {
					
					gs.MRegenPoints++;
					System.out.println(" _______________________________________________________________");
					System.out.println("|                                                               |");
					System.out.println("           ~ You devour the " + enemy + "'s corpse ~            ");
					System.out.println("            ~ You can now regen " + gs.MRegenPoints + " time(s)! ~     ");
					System.out.println("|                                                               |");
					System.out.println(" _______________________________________________________________\n");
			
				}
				
				System.out.println(" ________________________");
				System.out.println("|                        |");
				System.out.println("    What will you do?\n");
				System.out.println("   [ 1. Keep Eating ]");
				System.out.println("     [ 2. Evolve ]");
				System.out.println("|                        |");
				System.out.println(" ________________________\n");
				
				int userinput = sc.nextInt();
				
				if (userinput == 1) {
					System.out.println("\t ~ You continue to feast ~ ");
				}
				else if (userinput == 2 && EnemyKilled >= 5) { // You Evolve when you have killed 5 or more enemies
					System.out.println(" _______________________________________________________________");
					System.out.println("|                                                               |");
					System.out.println("|         [!} You Evolve and take over the Starship [!]         |");
					System.out.println("|                                                               |");
					System.out.println(" _______________________________________________________________\n");
					break;
				}
				else {
					System.out.println(" _______________________________________________________________");
					System.out.println("|                                                               |");
					System.out.println("|              [!]  Insufficient Lifeforms  [!]                 |");
					System.out.println("|              [!] You need 5 or more kills [!]                 |");
					System.out.println("|                                                               |");
					System.out.println(" _______________________________________________________________\n");
				}
			}

		System.out.println("\n\tThanks for Playing!");
		
		sc.close();
	}
}
