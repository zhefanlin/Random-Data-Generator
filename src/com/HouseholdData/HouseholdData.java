package com.HouseholdData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class HouseholdData {

	/**
	 * @param args
	 * @return 
	 */
	private Map<Integer, Map<Integer, Double>> index;
	private Map<Integer, Double> subIndex; 
	private Map<Integer, Double> temp;
	
	public void createHouseholdTable(String filePath) {
		int i = 0;
		try{
			FileWriter fout = new FileWriter(filePath);	
		
			for(i=1;i<10001;i++){
				fout.write(i+"	"+generateRandomData.IPAddress()+";"+"\n");	
			}
			fout.close();
			System.out.println("Households Table Generated");
		}

		catch (IOException ei) {
			System.out.println("IO Exception");
		}	
	}
	
	public void createSegAndRanking(String filePath) {
		
		index = new HashMap<Integer, Map<Integer, Double>>();
		

		int i =0;
		int j =0;
		int l =0;
		try{
			FileWriter fout1 = new FileWriter(filePath);
			FileWriter fout2 = new FileWriter("/Users/Zhefan/Dropbox/SegmentTable.csv");	
	
			for(i=1;i<10001;i++){
				subIndex = new HashMap<Integer, Double>();  
				for(j=1;j<51;j++){
					
					Double s=generateRandomData.RankingScore();
					subIndex.put(j,s);
					
					fout1.write(i+"	"+j+"	"+s+";"+"\n");	
				}
				index.put(i, subIndex);
			}
			System.out.println("Ranking Table Generated");
			
			int count = 0;
			int k = 0;
			
			for(k=1;k<51;k++){
				//System.out.println("xxxxxxxxxxxxxxxxxxx");
				for(l=1;l<10001;l++){	
					Map<Integer, Double> temp = index.get(l);
					
					for (Map.Entry<Integer, Double> e : temp.entrySet()) { 
						double score= 0;
						
						if(e.getKey()==k){
							score=e.getValue();
							System.out.println(score);
							if(score>0.5){		
								count++;
							}
							
						
						//System.out.println(count);
						}
					}		
				}
				//System.out.println(count);
				fout2.write(k+"	"+generateRandomData.getRandomString(5)+"	"+count+";"+"\n");
				count = 0;	
			}
			System.out.println("Segment Table Generated");
				
			fout1.close();
			fout2.close();
		}
		catch (IOException ei) {
			System.out.println("IO Exception");
		}			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HouseholdData household = new HouseholdData(); 
		HouseholdData segment = new HouseholdData(); 
        household.createHouseholdTable("/Users/Zhefan/Dropbox/HouseholdsTable.csv");  		
		segment.createSegAndRanking("/Users/Zhefan/Dropbox/RankingTable.csv");


		System.out.println("Done");
	}

}
