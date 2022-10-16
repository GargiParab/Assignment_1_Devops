package com.demo.pdf.gen.service;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class BlobCreation {
	
	
	public String createBlob() {
		File file = new File("D:\\demo\\demo.zip");
        byte[] bytes = new byte[(int)file.length()];
        try {
        	FileInputStream i=new FileInputStream("D:\\\\demo\\\\demo.zip");
        	BufferedInputStream b=new BufferedInputStream(i);
        	System.out.println("gen pdf");
            DataInputStream dataInputStream = new DataInputStream(b);
            dataInputStream.readFully(bytes);
            System.out.println("gen pdf");
            System.out.println(String.format(Arrays.toString(bytes)));
//            byte [] b1=new byte[];
            for (byte b1 : bytes) {
                System.out.format("0x%x ", b);
            }
            dataInputStream.close();
            Blob blob=new javax.sql.rowset.serial.SerialBlob(bytes);
            String s=blob.toString();
            return "success";
        }
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return "failed";
	}

}
