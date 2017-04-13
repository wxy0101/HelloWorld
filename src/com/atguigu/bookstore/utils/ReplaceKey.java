package com.atguigu.bookstore.utils;

import java.io.File;

public class ReplaceKey {

	public static void  replaceKey(File file,String key,String replacement){
		File[] files = file.listFiles();
		for (File file2 : files) {
			//当file2为文件夹时 继续迭代此操作
			if(file2.isDirectory()){
				replaceKey(file2,key,replacement);
			}
			//当file为文件时，进行修改
			if(file2.isFile()){
				//获取file2的名字
				String name = file2.getName();
				//截取名字最后和key等长度的字符串
				String substring = name.substring(name.length()-key.length());
				
				//判断是否相等,若想等则用replacement进行替换
				if(substring.equals(key)){
					String absolutePath = file2.getParent();
					String name2 = file2.getName();
					
					String substring2 = name2.substring(0, name2.length()-key.length())+replacement;
					System.out.println(absolutePath+substring2);
					file2.renameTo(new File(absolutePath,substring2));
				}
				
			}
			
			
		}
	}
	

}
