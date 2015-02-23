import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
public class TextFileRead {
public static void main(String[] args) {
ArrayList<String> wordList = new ArrayList();
BufferedReader br = null;
try {
String sCurrentLine;
br = new BufferedReader(new FileReader("C:/Test.txt"));
br.mark(1000);
/*
* readAheadLimit - Limit on the number of characters that may be
* read while still preserving the mark. An attempt to reset the
* stream after reading characters up to this limit or beyond may
* fail.
*/
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
//StopWordRemove.stopwordRemove(wordList);
Iterator itr = wordList.iterator();
while (itr.hasNext()) {
System.out.println(itr.next());
}
} catch (IOException e) {
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