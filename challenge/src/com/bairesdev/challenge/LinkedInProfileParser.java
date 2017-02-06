package com.bairesdev.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LinkedInProfileParser {

	private LinkedInProfileParser() {
		// utility class
	}

	public static LinkedInProfile parseFromCsv(final String data) {
		final LinkedInProfile linkedInProfile = new LinkedInProfile();
		final List<String> fields = Arrays.asList(data.split(Pattern.quote("|")));
		assert fields.size() == linkedInProfile.getSetters().size();
		try {
			for (int i = 0; i < fields.size(); ++i) {
				linkedInProfile.getSetters().get(i).accept(fields.get(i));
			}
			return linkedInProfile;
		} catch (Exception e) {
			System.err.println("Error parsing this line");
			System.err.println(data);
		}
		return null;
	}
}
