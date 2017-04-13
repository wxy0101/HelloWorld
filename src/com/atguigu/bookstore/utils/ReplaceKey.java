package com.atguigu.bookstore.utils;

import java.io.File;

public class ReplaceKey {

	public static void  replaceKey(File file,String key,String replacement){
		File[] files = file.listFiles();
		for (File file2 : files) {
			//��file2Ϊ�ļ���ʱ ���������˲���
			if(file2.isDirectory()){
				replaceKey(file2,key,replacement);
			}
			//��fileΪ�ļ�ʱ�������޸�
			if(file2.isFile()){
				//��ȡfile2������
				String name = file2.getName();
				//��ȡ��������key�ȳ��ȵ��ַ���
				String substring = name.substring(name.length()-key.length());
				
				//�ж��Ƿ����,���������replacement�����滻
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
