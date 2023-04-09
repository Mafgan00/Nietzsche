package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CompileAndRun {
  public static void main(String[] args) {
    //if (args.length != 1) {
    //  System.out.println("エラー：ファイル名を指定してください。");
    //  return;
    //}
    String fileName = "Hello.java";
    try {
      ProcessBuilder pb = new ProcessBuilder("javac", fileName);
      Process proc = pb.start(); //コンパイル実行
      proc.waitFor();

      pb = new ProcessBuilder("java", fileName.replace(".java", ""));
      proc = pb.start(); //実行
      InputStream is = proc.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      String line;
      while ((line = br.readLine()) != null) { //実行結果を標準出力
        System.out.println(line);
      }

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}