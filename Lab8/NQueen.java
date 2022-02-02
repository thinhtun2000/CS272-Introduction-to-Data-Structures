package lab8;

import java.util.Scanner;

public class NQueen {

	public static void solve( int N ) {
		ArraylistStack<Integer> S = new ArraylistStack<Integer> ();

		int Qpos = 0;
		while ( !(Qpos > N) ) {
			if( S.size() == N ) {
				break;
			}
			if( Qpos == N ) {
				if( (S.get() == N) && (S.size() == 1) ) {
					break;
				}
				if( S.get() == N ) {
					S.pop();
					Qpos = S.pop() + 1;
				}
				else{
					Qpos = S.pop() + 1;
				}
			}
			else if( checkConflict(Qpos, S) ) {
				S.push(Qpos);
				Qpos = 0;
			}
			else{
				Qpos++;
			}
		}
		if( S.size() == N ) {
			printStack(S);
		}
    }
	
	public static boolean checkConflict(int Qpos, ArraylistStack<Integer> S) {
		for (int i = 0; i < S.size(); i++) {
			if (S.get(i) == Qpos){
				return false;
			}
			if ((S.get(i) - Qpos) == (S.size() - i)){
				return false;   
			}
			if ((Qpos - S.get(i)) == (S.size() - i)){
				return false;   
			}
		}
		return true;
	}
	//this method prints out a solution from the current stack


	private static void printStack(ArraylistStack<Integer> s) {
		for (int i = 0; i < s.size(); i ++) {
			for (int j = 0; j < s.size(); j ++) {
				if (j == s.get(i))
					System.out.print("Q ");
				else
					System.out.print("- ");
			}
			System.out.println();
		}
		System.out.println();  
	}


	public static void main(String[] args) {
		int N;
		System.out.print("Please enter N: ");
		Scanner scnr = new Scanner(System.in);
		N = scnr.nextInt();
		solve(N);
	}
}