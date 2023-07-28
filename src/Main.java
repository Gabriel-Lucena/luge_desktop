import java.util.Scanner;

import Models.User;

public class Main {

	public static void main(String[] args) {
		
		String username = null;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um nome de usuário:");
		
		try {
			username = scanner.next();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		scanner.close();
		
		User usuario = new User(username);
		
		System.out.println(usuario.all_users());
	}

}
