/*
  同じフォルダに読み込み元のファイル data_readSample.txt が必要
  ファイルからデータを読み込むメソッドを３通り示している、
  いずれも同じ処理を行う
  readSample1() : C言語風
  readSample2() : 2と3の中間
  readSample3() : Java風
*/

import java.io.*;

public class FileRead{

    public static void main(String[] args){
	readSample1();
	readSample2();
	readSample3();
    }
    
    private static void readSample1(){
	System.out.println("readSample1 : ");

	try{
	    // 変数宣言を個別に行った例（C言語風）

	    File file_read;
	    FileReader fr;
	    BufferedReader br;
	    String data;

	    file_read = new File("FileRead_data.txt");
	    fr = new FileReader(file_read);
	    br = new BufferedReader(fr);

	    // 以降読み込み処理

	    data = br.readLine();  // １行まとめて読み込み
	    br.close();  // 読み込みが終わった時点でクローズする
	    System.out.println(data);  // 画面に出力

	} catch(IOException e){

	    MyException.disp(e);
	}
    }


    private static void readSample2(){
	System.out.println("readSample2 : ");

	try{
	    // 宣言を個別に行った例
	    // 変数宣言と初利用の箇所が一致しているので読みやすい

	    File file_read = new File("FileRead_data.txt");
	    FileReader fr = new FileReader(file_read);
	    BufferedReader br = new BufferedReader(fr);

	    // 以降読み込み処理

	    String data = br.readLine();  // １行まとめて読み込み
	    br.close();  // 読み込みが終わった時点でクローズする
	    System.out.println(data);  // 画面に出力

	} catch(IOException e){

	    MyException.disp(e);

	}
    }


    private static void readSample3(){
	System.out.println("readSample3 : ");
	try{
	    // 宣言をまとめて行った例
	    // 記述が長いが少ない変数で実現できる
	    // readSample01, 02 で宣言したfile_read, frなどがここでは不要

	    BufferedReader br = new BufferedReader(new FileReader(new File("FileRead_data.txt")));;

	    // 以降読み込み処理
	    String data = br.readLine();  // １行まとめて読み込み
	    br.close();  // 読み込みが終わった時点でクローズする
	    System.out.println(data);  // 画面に出力

	} catch(IOException e){

	    MyException.disp(e);

	}
    }

}
