package com.HouseholdData;

import java.util.Random;

public class generateRandomData {

	/**
	 * @param args
	 */
	public static Random r = new Random();
	
	public static String IPAddress(){
		StringBuilder sb = new StringBuilder();
		sb.append(r.nextInt(256));
		sb.append(".");
		sb.append(r.nextInt(256));
		sb.append(".");
		sb.append(r.nextInt(256));
		sb.append(".");
		sb.append(r.nextInt(256));
		String ip = sb.toString();
		return ip;		
	}
	public static double RankingScore(){
		double s = r.nextDouble();
		return s;
	}
	public static String getRandomString(int length) {   
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   
        Random random = new Random();   
        StringBuffer sb = new StringBuffer();   
        for (int i = 0; i < length; i++) {   
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
        }   
        return sb.toString();   
    }   
}
