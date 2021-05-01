package com.testvagrant.runners;

import java.io.IOException;

import io.cucumber.core.cli.Main;


public class TestRunner{
	private static String festuresLoc;
	private static String tag;
	//private static String remoteURL;
	private static String threads;
	public static void main(String[] args) throws IOException {
		if(args.length==0) {
			System.out.println("11");
			festuresLoc = "src/main/resources/features";
			tag = "@WeatherUI";
			//remoteURL ="Local";
			threads = "1";
		}
		System.out.println("22");
		cucumberKickoff();
	}

	private static void cucumberKickoff() throws IOException {
		System.out.println("1");
		String[] argv = new String[] {festuresLoc, "-p", "pretty", "-p", "html:target/cucumber","-p",
				"json:target/report/cucumber.json", "-g", "classpath:com.testvagrant.steps", "-g", "classpath:com.testvagrant.coreUtils","-t", tag,
				"--threads", threads};
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		Main.run(argv,contextClassLoader);
		}
	}
