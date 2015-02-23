import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.*;
public class oracleread {
static Connection c;
public static void main(String args[ ]) throws Exception {
int ch;
ArrayList<String> wordList = new ArrayList();
FileOutputStream f = new FileOutputStream("C:/Test1.txt"); 


String sCurrentLine;


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


catch(Exception e) { }
//end main( )
// display all the records

try {
String query = "SELECT * FROM STUDENT";
int row = 0;
Statement st = c.createStatement();
ResultSet r = st.executeQuery(query);
System.out.println("Name \t id");
System.out.println("**********************************");
while(r.next())
{
System.out.println(r.getString(1)+"\t"+r.getInt(2)+"\t");

	   
	
    String qq=r.getString(1)+" "+r.getInt(2)+" ";
	byte[] contentInBytes = qq.getBytes();
       f.write(contentInBytes);
    System.out.println(contentInBytes);
}

}


//st.close( );

catch(Exception e)
{
	e.printStackTrace();
}

finally {
    if (f != null) {
       f.close();
    }
 }


BufferedReader br = null;
try
{

br = new BufferedReader(new FileReader("C:/Test1.txt"));
br.mark(1000);
System.out.println("Original Content of the File");
System.out.println("*********************************");
while ((sCurrentLine = br.readLine()) != null) {
System.out.println(sCurrentLine);
}
br.reset();
System.out.println(" ");
System.out.println("Creating Tokens");
System.out.println("*********************************");
while ((sCurrentLine = br.readLine()) != null) {
/*
* Creating token based on the split function
*
* String[] token = sCurrentLine.split(" "); for(int
* i=0;i<token.length;i++){ System.out.println(token[i]);
*
* }
*/
/* Creating Token based on StringTokenizer */
StringTokenizer tokn = new StringTokenizer(sCurrentLine, " ");
while (tokn.hasMoreTokens()) {
// System.out.println(tokn.nextToken());
wordList.add(tokn.nextToken());
}
}
System.out.println("tokenized content of the File");
System.out.println("*********************************");
while ((sCurrentLine = br.readLine()) != null) {
System.out.println(sCurrentLine);
}
StopWordRemove.stopwordRemove(wordList);
Iterator itr = wordList.iterator();
while (itr.hasNext()) {
System.out.println(itr.next());
}
}
 catch (IOException e) {
e.printStackTrace();
} finally {
try {
if (br != null)
br.close();
} catch (IOException ex) {
ex.printStackTrace();
}
}
}
}
//for clear the screen
//static void clrscr() {
//for(int k=1;k<25;k++)
//System.out.println( );

//insert the record 178 Aman ECE 90

//class end