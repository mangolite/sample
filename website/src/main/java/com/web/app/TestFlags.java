package com.web.app;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.google.common.collect.MapDifference;
import com.utils.JsonUtil;
import com.web.models.Greeting;
import com.web.models.HelloMessage;
import com.web.models.Tag;
import com.webutils.json.JsonUpdate;

public final class TestFlags {

	private TestFlags() {
		throw new IllegalStateException(
				"This is a class with static methods and should not be instantiated");
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		try {

			File folder = new File("lib");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("File " + listOfFiles[i].getName());
				} else if (listOfFiles[i].isDirectory()) {
					System.out.println("Directory " + listOfFiles[i].getName());
				}
			}
			/*
			 * Greeting greet = new Greeting("original");
			 * greet.getTags().add(new Tag("0", "A")); greet.getTags().add(new
			 * Tag("2", "B")); greet.setMessage(new HelloMessage());
			 * System.out.println(JsonUtil.toJson(greet)); JsonUpdate up = new
			 * JsonUpdate(greet); // Map<String, Object> orig =
			 * JsonUtil.toMap(greet); greet.setTopic("newTopic");
			 * greet.getTags().get(1).setName("D"); greet.getTags().set(0, new
			 * Tag("5", "F")); greet.getTags().add(new Tag("3", "C"));
			 * greet.getTags().add(new Tag("4", "E"));
			 * greet.getMessage().setName("not hello"); // Map<String, Object>
			 * newGreet = JsonUtil.toMap(greet); // MapDifference<String,
			 * Object> diff = JsonUtil.getDiff(orig, // newGreet);
			 * System.out.println("sdd"); System.out.println(up.diff()); //
			 * up.setOrigObject(greet); // greet.getTags().remove(3); //
			 * System.out.println("sdd"); //
			 * System.out.println(JsonUtil.toJson(up.diffObj()));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
