import java.util.ArrayList;
public class StopWordRemove {
public static void stopwordRemove(ArrayList<String> wordList) {
String[] stopWordsofwordnet = { "without", "see", "unless", "due",
"also", "must", "might", "like", "will", "may", "can", "much",
"every", "the", "in", "other", "this", "the", "many", "any",
"an", "or", "for", "in", "an", "an", "is", "a", "about",
"couldn’t", "did", "didn’t", "do", "does", "doesn’t", "doing",
"don’t", "down", "during", "each", "few" };
// remove stop words here from the temp list
for (int i = 0; i < wordList.size(); i++) {
// get the item as string
for (int j = 0; j < stopWordsofwordnet.length; j++) {
if (stopWordsofwordnet[j].contains(wordList.get(i))) {
wordList.remove(i);
i--;
break;
}
}
}
}
}