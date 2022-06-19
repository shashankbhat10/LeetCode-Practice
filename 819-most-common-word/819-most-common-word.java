class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
//         Set<String> bannedWords = new HashSet<>();
        
//         String paragraphLower = paragraph.toLowerCase();
//         for(int i=0; i<banned.length; i++){
//             bannedWords.add(banned[i]);
//         }
        
//         Map<String, Integer> hm = new HashMap<String, Integer>();
        
//         int start = 0;
//         int end = 0;
//         boolean wordStarted = false;
//         int maxCount = 0;
//         String maxWord = "";
//         for(int i=0; i<paragraphLower.length(); i++){
//             if(Character.isLetter(paragraphLower.charAt(i)) && !wordStarted){
//                 start = i;
//                 wordStarted = true;
//             } else if(!Character.isLetter(paragraphLower.charAt(i)) && wordStarted){
//                 String tempWord = paragraphLower.substring(start, i);
//                 // System.out.println(tempWord);
//                 if(!bannedWords.contains(tempWord)){
//                     // if(maxCount < (hm.getOrDefault(tempWord, 0) + 1)){
//                     //     maxCount = hm.getOrDefault(tempWord, 0) + 1;
//                     //     maxWord = tempWord.toLowerCase();
//                     // } else {
//                     //     hm.put(tempWord, hm.getOrDefault(tempWord, 0) + 1);
//                     // }
//                     hm.put(tempWord, hm.getOrDefault(tempWord, 0) + 1);
//                     wordStarted = false;
//                 }
//                 wordStarted = false;
//             }
//         }
        
//         if(wordStarted){
//             String tempWord = paragraphLower.substring(start, paragraphLower.length());
//             if(!bannedWords.contains(tempWord)){
//                 // if(maxCount < (hm.getOrDefault(tempWord, 0) + 1)){
//                     // maxCount = hm.getOrDefault(tempWord.toLowerCase(), 0) + 1;
//                     // maxWord = tempWord.toLowerCase();
//                     // return tempWord;
//                 hm.put(tempWord, hm.getOrDefault(tempWord, 0) + 1);
//                 // }
//             }
//         }
        
//         for(String word : hm.keySet()){
//             System.out.println(word);
//             System.out.println(hm.get(word));
//         }
//         // for(int i=0; i<hm.keySet.length; i++){
            
//         // }
        
//         return maxWord;
        
        // String[] words = paragrpa
        Set<String> bannedWords = new HashSet<String>();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        
        for(int i=0; i<banned.length; i++){
            bannedWords.add(banned[i].toLowerCase());
        }
        
        String paragraphLowered = paragraph.toLowerCase();
        boolean wordStarted = false;
        int start = 0;
        for(int i=0; i<paragraphLowered.length(); i++){
            if(Character.isLetter(paragraphLowered.charAt(i)) && !wordStarted){
                start = i;
                wordStarted = true;
            } else if(!Character.isLetter(paragraphLowered.charAt(i)) && wordStarted){
                String tempWord = paragraphLowered.substring(start, i);
                wordStarted = false;
                if(!bannedWords.contains(tempWord))
                    hm.put(tempWord, hm.getOrDefault(tempWord, 0) + 1);
            }
        }
        
        if(wordStarted){
            String tempWord = paragraphLowered.substring(start, paragraphLowered.length());
            if(!bannedWords.contains(tempWord)){
                hm.put(tempWord, hm.getOrDefault(hm.get(tempWord), 0) + 1);
            }
        }
        
        String result = "";
        for(String word : hm.keySet()){
            if(result.equals("")){
                result = word;
            } else {
                if(hm.get(result) < hm.get(word)){
                    result = word;
                }
            }
        }
        
        return result;
    }
}