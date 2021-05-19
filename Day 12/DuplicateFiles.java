import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
// https://leetcode.com/problems/find-duplicate-file-in-system/

public class DuplicateFiles {

    static void insertOrUpdateMap(HashMap<String, ArrayList<String>> map, String filename, String content) {
        if(map.containsKey(content)) {
            ArrayList<String> list = map.get(content);
            list.add(filename);
            map.put(content, list);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(filename);
            map.put(content, list);
        }
    }

    static List<List<String>> findDuplicate(String[] paths) {
        String fileAndContent[] = null;

        String pattern = "(\\w+.txt)\\((\\w+)\\)";
        Pattern r = Pattern.compile(pattern);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String path : paths) {
            fileAndContent = path.split(" ");

            //root location
            String rootDir = fileAndContent[0];
            
            //token is the file name containing content too
            for(int i = 1; i<fileAndContent.length; i++) {
                String token = fileAndContent[i];
                Matcher m = r.matcher(token);
                String fileName = "";
                String content = "";
                
                while (m.find()) {
                    fileName =  rootDir + "/" + m.group(1); 
                    content =  m.group(2);
                 }

                 insertOrUpdateMap(map, fileName, content);
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        map.forEach((k,v) -> {
            if(v.size()>1)
                ans.add(v);
        });
        return ans;

    }

    public static void main(String ...arg) {
        String [] paths= new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};
        findDuplicate(paths);
    }
}