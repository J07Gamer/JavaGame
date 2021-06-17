package javagame;

import java.util.*;

public class GameSettings {
	
	//System Variables
	Random rdm = new Random();
			
			
	//Game Units
	String[] enemyUnits = { "Soldier", "Sergeant", "Captain", "Admiral", "Gunner", "Officer", "Agent" };
			
	//Enemy Stats - Health and Attack
	int EnemyHealth = 100;
	int EnemyAttack = 30;
			
	//Monster Stats
	int MHealth = 150;
	int MAttack = 50;
	int MRegenPoints = 2; //How many times the Monster can regenerate
	int MRegenAmount = 30; //How much the Monster Heals for
	int MRegenRecover = 65; //Percentage of the Monster eating an enemy

	public int RandomHealth() { //Randomizes Health for enemy
		this.EnemyHealth = new Random().nextInt((100 - 1) + 1) + 1;
		return EnemyHealth;
	}
	
	public int RandomAttack() { //Randomizes Attack for enemy
		this.EnemyAttack = new Random().nextInt((30 - 1) + 1) + 1;
		return EnemyAttack;
	}
	
	public int MRandomAttack() { //
		this.MAttack = new Random().nextInt((50 - 1) + 1) + 1;
		return MAttack;
	}
	
	
}
