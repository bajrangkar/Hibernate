package com.encrypt;

import java.io.File;
import java.util.Scanner;

public class EncryptDecrypt {
	public static void main(String[] args) {
		String key = "One Two Cha Cha!";
		File encryptedFile = new File(".trace");
		File decryptedFile = new File(".log");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 1 to Encrypt");
			System.out.println("Enter 2 to Decrypt");
			System.out.println("Enter 3 to Exit");
			int i = sc.nextInt();
			switch(i) {
				case 1:
					try {
						EncryptUtil.encrypt(key, decryptedFile, encryptedFile);
						System.out.println("~:~:~:~ .E. .N. .C. .R. .Y. .P. .T. .E. .D. ~:~:~:~");
					decryptedFile.delete(); 
					} catch (CryptoException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
					}
					break;
				case 2:
					try {
						EncryptUtil.decrypt(key, encryptedFile, decryptedFile);
						System.out.println("~:~:~:~ .D. .E. .C. .R. .Y. .P. .T. .E. .D. ~:~:~:~");
					} catch (CryptoException ex) {
						System.out.println(ex.getMessage());
						ex.printStackTrace();
					}
					break;
				case 3:
					System.out.println("~:~:~:~ .E. .X. .I. .T. ~:~:~:~");
					sc.close();
					System.exit(0);
			}
		}
		
	}
}
