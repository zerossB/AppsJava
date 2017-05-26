package jexceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JExceptions {

	public static void main(String[] args) {
		try {
			Path path = Paths.get(System.getProperty("user.home"), "pgadmin.log");
			Files.lines(path).forEach(System.out::println);
			
			String linhaNova = "Linha criada em " + new java.util.Date().toString();
			Files.write(path, linhaNova.getBytes());
			
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
