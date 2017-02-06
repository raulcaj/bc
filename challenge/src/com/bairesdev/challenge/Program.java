package com.bairesdev.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Program {
	
	public static void main(String[] args) {
		final List<LinkedInProfile> rankedProfiles = readFile().stream().map(LinkedInProfileParser::parseFromCsv).filter(Objects::nonNull).sorted().collect(Collectors.toList());
		for(int i = 0; i < rankedProfiles.size(); ++i) {
			final LinkedInProfile profile = rankedProfiles.get(i);
			System.out.printf("Rank: %dº - Weight: %d:\n %s\n", i+1, ProfileRanker.INSTANCE.rank(profile), profile);
		}
	}
	
	

	private static List<String> readFile() {
		try {
			return Files.readAllLines(Paths.get("PeopleToRate.txt"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return new ArrayList<>();
	}
}
