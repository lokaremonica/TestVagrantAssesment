package com.testvagrant.runners;

import io.cucumber.core.cli.Main;

public class TestRunner{
	private static String festuresLoc;
	private static String tag;
	private static String remoteURL;
	private static String threads;
	public static void main(String[] args) {
		if(args.length==0) {
			festuresLoc = "src/main/resources";
			tag = "@Weather";
			remoteURL ="Local";
			threads = "1";
		}
		cucumberKickoff();
	}

	private static byte cucumberKickoff() {
		String[] argv = new String[] {festuresLoc, "-p", "pretty", "-p", "html:target/cucumber-reports","-p",
				"json:target/report/cucumber.json", "-g", "classpath:com.testvagrant.steps", "-t", tag,
				"--threads", threads};
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		byte exitstatus = Main.run(argv,contextClassLoader);
		return exitstatus;
		}
	}
