import java.sql.*;
import java.io.*;

public class test {
   static Connection c;
   public static void main(String args[ ]) throws Exception {
   	int ch;
   	InputStreamReader i = new InputStreamReader(System.in);
   	BufferedReader b = new BufferedReader(i);
   	try {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","azadAZAD1");
		}
		catch(ClassNotFoundException error) {
       			System.err.println("Unable to load the JDBC/ODBC bridge" + error.getMessage( ));
       			System.exit(1);
		}
		catch(SQLException error) {
       			System.err.println("Unable to connect to databas---" + error.getMessage( ));
       			System.exit(2);
		}
	         	do {
	   		System.out.println("\t\tMenu");
	   		System.out.println("\t\t1.View\n\t\t2.Clear\n\t\t3.Insert");
	   		System.out.println("\t\t4.Modify\n\t\t5.Delete\n\t\t6.Exit");
	   		System.out.print("Enter your choice :  ");	
           			ch = Integer.parseInt(b.readLine());	
	   		switch(ch) {
			       case 1 : display( ); break;
			       case 2 : clrscr( ); break;
	        		       case 3 : insert( ); display( ); break;
			       case 4 : modify( ); display( ); break;
			       case 5 : delete( ); display( ); break;
			       case 6 : System.out.println("\nThank you"); System.exit(0);
			      default : System.out.println("\nInvalid input");
	   		}						
	  	}while(ch!=6);
		c.close();
	}
  	catch(Exception e) { }
    }//end main( )

    // display all the records
    static void display( ) {
           try  {
	String query = "SELECT * FROM STUDENT";
	int row = 0;
	Statement st = c.createStatement();
	ResultSet r = st.executeQuery(query);
	System.out.println("Name \t id");
	System.out.println("**********************************");
	while(r.next())
		System.out.println(r.getString(1)+"\t"+r.getInt(2)+"\t");
	st.close( );	
          }
          catch(Exception e){ }
    }
	
    //for clear the screen
    static void clrscr()  {
         for(int k=1;k<25;k++)
	System.out.println( );
    }

    //insert the record 178 Aman ECE 90
    static void insert( )  {
         try  {
	Statement ins_st=c.createStatement();
	
	System.out.println("Aman,90");
	String VAR="Aman";
	int ID=90;
	int row=ins_st.executeUpdate("insert into STUDENT values('" +VAR+"',"+ID+")");
	c.commit();
	System.out.println("No of rows inserted ="+row);
        } 
        catch(SQLException e) {
	System.out.println("Error in insert\n"+e);
        }
   }
  
    //update the record where regno =178 mark = 100
    static void modify( )  {
          try    {
	System.out.println("Aman change 90 to 100");
	Statement modi_st=c.createStatement();
	int row=modi_st.executeUpdate("update STUDENT set ID=100");
	System.out.println("No of rows updated ="+row);
         }
         catch(SQLException e) {
	System.out.println("Error in modify\n"+e);
         }
    }

    //delete the record 178 Aman ECE 100
    static void delete()  {
         try   {
	System.out.println("178,Aman ECE");
	
	Statement del_st = c.createStatement();
	int row = del_st.executeUpdate("delete from STUDENT where ID = 90");
	if(row>0) 	{
		c.commit();
		System.out.println("No of rows deleted ="+row);
	}	
	else {
		System.out.println("Record not found");
	}
         }
         catch(SQLException e)  {
	System.out.println("Error in delete\n"+e);
         }
    }

}//class end
