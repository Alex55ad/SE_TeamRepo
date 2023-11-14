package com.rss.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class SeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeApplication.class, args);
		openBrowser("http://localhost:8080/");
	}
	private static void openBrowser(String url) {
		String os = System.getProperty("os.name").toLowerCase();
		Runtime rt = Runtime.getRuntime();

		try {
			if (os.contains("win")) {
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} else if (os.contains("mac")) {
				rt.exec("open " + url);
			} else if (os.contains("nix") || os.contains("nux")) {
				rt.exec("xdg-open " + url);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

