package com.example.eshopping.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class ImportCSV {

	public static void main(String[] args) {
		
		PreparedStatement ps=null;
		BufferedReader br=null;

		 try{
			  
			 Connection connection = DBConnection.getConnection(); 
			    br=new BufferedReader(new FileReader("/C:/Users/lakshmanan/Documents/Projects/Ashok_Referred_Project/Project_Assests/Pincodes.csv"));
			    String sql = "INSERT INTO `pincode` (`ID`,`PIN_CODE`)  "
			    		+ "VALUES(?,?)";
                
			    ps=connection.prepareStatement(sql);
			    String line=null;
			    int i=20060;
			    while((line=br.readLine())!=null){
			    
			    	String[] value=line.split(",");
			    	
			    	System.out.println(i++ +":len:"+value[1]+"-Loading.."+value[0]);
			    	
			    	
			    	ps.setLong(1, i);
			    	ps.setString(2,  value[0]);

			    	ps.executeUpdate();
			    	i++;

				 }
			    
				    br.close();
				    ps.close();
				    connection.close();
//			  FileInputStream input = new FileInputStream("C:/Users/lakshmanan/Pictures/Airframe.xlsx");
//	            POIFSFileSystem fs = new POIFSFileSystem( input );
	/*		 OPCPackage pkg = OPCPackage.open("C:/Users/lakshmanan/Downloads/ASA.xls");
	            XSSFWorkbook wb = new XSSFWorkbook(pkg);
	            XSSFSheet sheet = wb.getSheetAt(0);
	            Row row;
	            for(int i=1; i<=sheet.getLastRowNum(); i++){
	                row = sheet.getRow(i);*/
//	                System.out.println("1 "+row.getCell(1).getStringCellValue()+" 2 "+row.getCell(2).getStringCellValue()+" 3. "+row.getCell(3).getStringCellValue()+".4."+row.getCell(4).getStringCellValue()+",5,"+row.getCell(5).getStringCellValue());
//	                System.out.println("1 "+row.getCell(6)+" 2 "+row.getCell(7).getStringCellValue()+" 3. "+row.getCell(8).getStringCellValue()+".4."+row.getCell(9).getStringCellValue()+",5,");
//	                String name = row.getCell(0).getStringCellValue();
//	                String address = row.getCell(1).getStringCellValue();
//	                String address2 = row.getCell(2).getStringCellValue();
//	                String address3 = row.getCell(3).getStringCellValue();
//	                String city = row.getCell(4).getStringCellValue();
//	                String state = row.getCell(5).getStringCellValue();
//	                String zipcode = String.valueOf(row.getCell(6));
//	                String designator = row.getCell(7).getStringCellValue();
//	                String certifiacteOffice = row.getCell(8).getStringCellValue();
//	                String certificateNo = row.getCell(9).getStringCellValue();
	               /* String sql = "INSERT INTO `business_sample` (`NAME`,`CITY`,`STATE`,`COUNTRY`,`EXPIRATION_DATE`)  VALUES('"+ row.getCell(0)+"','"+ row.getCell(1)+"','"+ row.getCell(2)+"','"+ row.getCell(3)+"','"+ row.getCell(4)+"')";
	                ps = (PreparedStatement) connection.prepareStatement(sql);
	                ps.execute();
	                System.out.println("Import rows "+i);
	            }
	            connection.commit();
	            ps.close();
	            connection.close();
	            pkg.close();
	            System.out.println("Success import excel to mysql table");
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }*/
	}
		 catch(Exception e){
			 e.printStackTrace();
		 }
}

}
