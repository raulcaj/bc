package com.bairesdev.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProfileRanker {
	public static ProfileRanker INSTANCE = new ProfileRanker();
	private static Map<LinkedInProfile, Integer> CACHE = new HashMap<>();

	private List<Function<LinkedInProfile, Integer>> rankingFunctions = Arrays.asList(this::numberOfConnections,
			this::numberOfRecommendations, this::isLatamCountry, this::isInITIndustry);

	private ProfileRanker() {
		// Singleton
	}

	public int rank(final LinkedInProfile profile) {
		if (CACHE.containsKey(profile)) {
			return CACHE.get(profile);
		}
		Integer rankResult = rankingFunctions.stream().map(f -> f.apply(profile)).reduce(Integer::sum).orElse(0);
		CACHE.put(profile, rankResult);
		return rankResult;
	}

	private int numberOfConnections(final LinkedInProfile profile) {
		return tryParseIntegerOrZero(profile.getNumberOfConnections());
	}


	private int numberOfRecommendations(final LinkedInProfile profile) {
		return tryParseIntegerOrZero(profile.getNumberOfRecommendations());
	}

	private int tryParseIntegerOrZero(final String s) {
		try {
			return Integer.parseInt(s.trim());
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private int isLatamCountry(final LinkedInProfile profile) {
		final List<String> latamCountries = Arrays.asList("ARGENTINA", "PERU");
		return latamCountries.contains(profile.getCountry().toUpperCase()) ? 200 : 0;
	}

	private int isInITIndustry(final LinkedInProfile profile) {
		final List<String> itIndustries = Arrays.asList("SOFTWARE", "COMPUTER", "IT", "TECNOLOGY", "INFORMATION");
		return itIndustries.stream().anyMatch(profile.getCurrentRole().toUpperCase()::contains) ? 50 : 0;
	}

	// .. many more possible ranking methods
}
