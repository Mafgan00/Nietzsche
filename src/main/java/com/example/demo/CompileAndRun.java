package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CompileAndRun{
	public static void main(String[] args){
		try{

			ProcessBuilder pb = new ProcessBuilder("javac", "Main.java");
			Process p = pb.start();
			p.waitFor();

			pb = new ProcessBuilder("java", "Main");
			p = pb.start();
			
			//テストケース入力
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write("10\n");
			bw.write("in that case you should print yes and not no\n");
			bw.close();
			
			//出力確認
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = br.readLine();
			if("Yes".equals(line)){
				System.out.println("Test passed");
			}else{
				System.out.println("Test failed");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}