package org.pooja.recursion;

/**
 * The Tower of Hanoi is consists of three rods and number of disks. 
 * The puzzle starts with the disks arranged on a single rod in ascending order (smallest
 * at the top). You have to move the entire stack on another rod, satisfying the below rules:
 * i. Only one and top most disk at time is moved
 * ii. No bigger disk is placed on the top of smaller disk.
 * @author Pooja
 *
 */

public class ToweOfHanoi {
	
	/**
	 * Move (n-1) i.e the top most disk on the temporary rod. Then move the nth disk on 
	 * the destination rod. Thus you have the largest disk at the bottom on the destination rod.
	 * Then move the (n-1) disks from the temporary rod to the destination rod.
	 * @param n
	 * @param origin
	 * @param dest
	 * @param temp
	 */
	public void solve(int n, String origin, String dest, String temp){
		if(n == 1){
			System.out.println("Moving the nth: "+n+" disk from the tower "+origin+" to tower "+dest);
			
		}else{
			solve(n-1,origin, temp, dest);
			System.out.println("Moving the nth "+n+" disk from tower "+origin+" to tower "+dest);
			solve(n-1,temp,dest,origin);
		}
	}
	
	public static void main(String[] args) {
		
		new ToweOfHanoi().solve(5, "A", "B", "C");
	}
}
