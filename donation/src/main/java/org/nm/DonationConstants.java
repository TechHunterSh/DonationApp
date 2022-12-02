package org.nm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.appengine.repackaged.com.google.common.collect.ImmutableMap;

public class DonationConstants {

	public static final String UNAME = "uname";
	public static final String EMAIL = "email";
	public static final String TELNUMBER = "telnumber";
	public static final String AMOUNT = "amount";
	public static final String RECIEPTN = "recieptn";
	public static final String DATEDEPOSIT = "dateDeposit";
	public static final String DATE = "date";
	//@formatter:off
	public static final Map<String, String> PURPOSE=ImmutableMap.<String, String>builder()
			.put("dhana","එදිනෙදා දාන : Daily Dana")
			.put("meditaion","භාවනා වැඩසටහන සඳහා : Meditation Program")
			.put("Dhammasermon","ශ්‍රී සද්ධර්ම සාකච්ඡා මාලාව: Dhamma Discussion Program")
			.build();
	//@formatter:on
	public static final String CONTRIBUTORS = "contributors";
	public static final String BLESSINGMESSAGE = "blessingMessage";
	public static final String DECEASED = "deceased";
}
