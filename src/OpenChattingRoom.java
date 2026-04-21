import java.util.*;

public class OpenChattingRoom {
        public String[] solution(String[] record) {

            Map <String, String> user = new HashMap<>();
            for (String log : record) {
                String[] logs = log.split(" ");

                if (logs[0].equals("Enter")) {
                    user.put(logs[1], logs[2]);
                } else if (logs[0].equals("Change")) {
                    user.put(logs[1], logs[2]);
                }
            }
            
            List<String> list = new ArrayList<>();
            for (int i = 0; i < record.length; i++) {
                String[] prints = record[i].split(" ");

                if (prints[0].equals("Enter")) {
                    list.add((user.get(prints[1]) + "님이 들어왔습니다."));
                } else if (prints[0].equals("Leave")) {
                    list.add((user.get(prints[1]) + "님이 나갔습니다."));
                }
            }

            return list.toArray(new String[0]);
        }
}
